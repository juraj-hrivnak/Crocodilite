package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.BlockFaceShape
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.init.SoundEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.*


abstract class AbstractPlaceableItem(name: String) : Block(Material.GLASS) {

    init {
        translationKey = "crocodilite.$name"
        setRegistryName(name)

        setHardness(0F)
        setResistance(0F)
    }

    abstract val itemResourceLocation: ResourceLocation

    override fun isReplaceable(worldIn: IBlockAccess, pos: BlockPos): Boolean {
        return true
    }

    @SideOnly(Side.CLIENT)
    override fun getOffsetType(): EnumOffsetType {
        return EnumOffsetType.XZ
    }

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return AxisAlignedBB(0.2, 0.0, 0.2, 0.8, 0.06, 0.8).offset(state.getOffset(source, pos))
    }

    override fun onBlockActivated(worldIn: World, pos: BlockPos?, state: IBlockState, playerIn: EntityPlayer?, hand: EnumHand?, heldItem: EnumFacing?, side: Float, hitX: Float, hitY: Float
    ): Boolean {
        worldIn.setBlockToAir(pos)
        worldIn.markBlockRangeForRenderUpdate(pos, pos)
        worldIn.scheduleUpdate(pos, this, tickRate(worldIn))

        playerIn!!.swingArm(EnumHand.MAIN_HAND)
        playerIn!!.playSound(SoundEvents.ENTITY_ITEMFRAME_REMOVE_ITEM, 1.0f, 1.0f)

        this.launchDropAsEntity(state, worldIn, pos!!, ItemStack(Item.REGISTRY.getObject(itemResourceLocation)))
        return true
    }

    fun launchDropAsEntity(state: IBlockState, world: World, pos: BlockPos, stack: ItemStack) {
        if (!world.isRemote) {
            val posX = pos.x + 0.5 + state.getOffset(world, pos).x
            val posY = pos.y + 0.062
            val posZ = pos.z + 0.5 + state.getOffset(world, pos).z
            val entityitem = EntityItem(world, posX, posY, posZ, stack)
            entityitem.motionX = 0.0
            entityitem.motionY = 0.0
            entityitem.motionZ = 0.0
            entityitem.setDefaultPickupDelay()
            world.spawnEntity(entityitem)
        }
    }

    fun canBlockStay(worldIn: World, pos: BlockPos, state: IBlockState): Boolean {
        val down = worldIn.getBlockState(pos.down())
        return down.block != Blocks.AIR
    }

    private fun checkAndDropBlock(world: World, pos: BlockPos, state: IBlockState) {
        if (!canBlockStay(world as World, pos, state)) {
            dropBlockAsItem(world, pos, state, 0)
            world.setBlockToAir(pos)
        }
    }

    override fun canPlaceBlockOnSide(worldIn: World, pos: BlockPos, side: EnumFacing): Boolean {
        return canBlockStay(worldIn, pos, defaultState)
    }

    override fun canPlaceBlockAt(worldIn: World, pos: BlockPos): Boolean {
        return canBlockStay(worldIn, pos, defaultState)
    }

    override fun neighborChanged(state: IBlockState, worldIn: World, pos: BlockPos, blockIn: Block, fromPos: BlockPos) {
        checkAndDropBlock(worldIn, pos, state)
    }

    // This will make sure that snow will be not generating on the block
    override fun getBlockFaceShape(worldIn: IBlockAccess, state: IBlockState, pos: BlockPos, face: EnumFacing
    ): BlockFaceShape {
        return BlockFaceShape.BOWL
    }

    @SideOnly(Side.CLIENT)
    override fun getRenderLayer(): BlockRenderLayer {
        return BlockRenderLayer.CUTOUT
    }

    // Rendering of the blocks behind
    @Deprecated("")
    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    @Deprecated("")
    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    override fun getItemDropped(state: IBlockState?, rand: Random?, fortune: Int): Item? {
        return Item.REGISTRY.getObject(itemResourceLocation)
    }
}
