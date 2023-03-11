@file:Suppress( "OVERRIDE_DEPRECATION")

package teksturepako.block.overgrown

import net.minecraft.block.*
import net.minecraft.block.material.Material
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.item.ItemBlock
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.common.EnumPlantType
import net.minecraftforge.common.IPlantable
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import panda.divergentunderground.DivergentUnderground
import java.util.*


class Overgrown(name: String, val block: Block) : Block(Material.GRASS), IGrowable {

    init {
        translationKey = "crocodilite.$name"
        setRegistryName(name)

        soundType = SoundType.STONE
        creativeTab = DivergentUnderground.Tab
        this.setHardness(1.5F)
        this.setResistance(2.0F)
        this.tickRandomly = true

        defaultState = blockState.baseState
            .withProperty(BlockGrass.SNOWY, false)
    }

    override fun updateTick(world: World, pos: BlockPos, state: IBlockState, rand: Random) {
        if (world.getLightFromNeighbors(pos.up()) < 4 && world.getBlockState(pos.up()).getLightOpacity(world, pos.up()) > 2) {
            world.setBlockState(pos, block.defaultState)
        }
    }

    override fun getActualState(state: IBlockState, worldIn: IBlockAccess, pos: BlockPos): IBlockState {
        val block = worldIn.getBlockState(pos.up()).block
        return state.withProperty(BlockGrass.SNOWY, (block == Blocks.SNOW || block == Blocks.SNOW_LAYER))
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return 0
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, BlockGrass.SNOWY)
    }

    @SideOnly(Side.CLIENT)
    override fun getRenderLayer(): BlockRenderLayer {
        return BlockRenderLayer.CUTOUT_MIPPED
    }

    override fun getHarvestTool(state: IBlockState): String? {
        return "pickaxe"
    }

    override fun canSustainPlant(
        state: IBlockState,
        world: IBlockAccess,
        pos: BlockPos,
        direction: EnumFacing,
        plantable: IPlantable
    ): Boolean {
        val plantType: EnumPlantType = plantable.getPlantType(world, pos.offset(direction))
        return plantable === Blocks.MELON_STEM
            || plantable === Blocks.PUMPKIN_STEM
            || plantType === EnumPlantType.Desert
            || plantType === EnumPlantType.Plains
            || plantType === EnumPlantType.Cave
    }

    // IGrowable implementation
    override fun canUseBonemeal(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState): Boolean {
        return canGrow(worldIn, pos, state, false)
    }

    override fun canGrow(worldIn: World, pos: BlockPos, state: IBlockState, isClient: Boolean): Boolean {
        return true
    }

    override fun grow(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState) {
        val blockpos = pos.up()
        for (i in 0..127) {
            var blockpos1 = blockpos
            for (j in 0 until i / 16) {
                blockpos1 =
                    blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1)
                if (worldIn.getBlockState(blockpos1.down()).block !== this || worldIn.getBlockState(blockpos1).isNormalCube) {
                    continue
                }
            }
            if (worldIn.isAirBlock(blockpos1)) {
                if (rand.nextInt(8) == 0) {
                    worldIn.getBiome(blockpos1).plantFlower(worldIn, rand, blockpos1)
                } else {
                    val iblockstate1 =
                        Blocks.TALLGRASS.defaultState.withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS)
                    if (Blocks.TALLGRASS.canBlockStay(worldIn, blockpos1, iblockstate1)) {
                        worldIn.setBlockState(blockpos1, iblockstate1, 3)
                    }
                }
            }
        }
    }
}

class OvergrownItemBlock(name: String, block: Block) : ItemBlock(block) {

    init {
        translationKey = "crocodilite.$name"
        setRegistryName(name)

        creativeTab = DivergentUnderground.Tab
    }

}
