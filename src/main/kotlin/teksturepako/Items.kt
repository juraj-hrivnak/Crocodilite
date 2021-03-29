package teksturepako

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.BlockFaceShape
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.*

// setRegistryName("coconut_item") doesn't need MOD_ID, It gets it automatically from the current mod that is loading
// It is the same thing is if you write: this.registryName = ResourceLocation(MOD_ID, "coconut_item")

val item : Item = object : Item() {
    init {
        translationKey = "crocodilite.coconut_item"
        setRegistryName("coconut_item")

        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}


val block: Block = object : Block(Material.GLASS) {
    init {
        translationKey = "crocodilite.stone"
        setRegistryName("stone")

        setHardness(3F)
        setResistance(15F)

        creativeTab = CreativeTabs.BUILDING_BLOCKS
        soundType = SoundType.STONE
    }

    // This make sure that snow will be not generating on the block
    override fun getBlockFaceShape(
        worldIn: IBlockAccess,
        state: IBlockState,
        pos: BlockPos,
        face: EnumFacing
    ): BlockFaceShape {
        return BlockFaceShape.BOWL
    }

    @SideOnly(Side.CLIENT)
    override fun getRenderLayer(): BlockRenderLayer {
        return BlockRenderLayer.CUTOUT
    }

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return AxisAlignedBB(0.2, 0.0, 0.2, 0.8, 0.06, 0.8)
    }

    // Rendering of the blocks behind
    @Deprecated("")
    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    //    override fun isNormalCube(state: IBlockState, world: IBlockAccess, pos: BlockPos): Boolean {
    //        return false
    //    }
    @Deprecated("")
    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    override fun getItemDropped(state: IBlockState?, rand: Random?, fortune: Int): Item {
        return item
    }
}

val itemBlock : ItemBlock = object : ItemBlock(block) {
    init {
        translationKey = "crocodilite.stone"
        setRegistryName("stone")

        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}
