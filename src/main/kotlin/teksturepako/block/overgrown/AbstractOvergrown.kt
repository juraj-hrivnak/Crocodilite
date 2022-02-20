package teksturepako.block.overgrown

import net.minecraft.block.Block
import net.minecraft.block.BlockGrass
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.item.ItemBlock
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraftforge.common.EnumPlantType
import net.minecraftforge.common.IPlantable
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly


abstract class AbstractOvergrown(name: String) : Block(Material.GRASS) {

    init {
        translationKey = "crocodilite.$name"
        setRegistryName(name)

        soundType = SoundType.STONE
        creativeTab = CreativeTabs.BUILDING_BLOCKS
        this.setHardness(0F)
        this.setResistance(0F)

        defaultState = blockState.baseState
            .withProperty(BlockGrass.SNOWY, false)
    }

    override fun getActualState(state: IBlockState, worldIn: IBlockAccess, pos: BlockPos): IBlockState? {
        val block = worldIn.getBlockState(pos.up()).block
        return state.withProperty(BlockGrass.SNOWY, (block == Blocks.SNOW || block == Blocks.SNOW_LAYER))
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState
    }

    override fun getMetaFromState(state: IBlockState?): Int {
        return 0
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, BlockGrass.SNOWY)
    }

    @SideOnly(Side.CLIENT)
    override fun getRenderLayer(): BlockRenderLayer {
        return BlockRenderLayer.CUTOUT_MIPPED
    }

    override fun canSustainPlant(
        state: IBlockState?, world: IBlockAccess?, pos: BlockPos, direction: EnumFacing,
        plantable: IPlantable
    ): Boolean {
        val plantType: EnumPlantType = plantable.getPlantType(world, pos.offset(direction))
        return plantable === Blocks.MELON_STEM
            || plantable === Blocks.PUMPKIN_STEM
            || plantType === EnumPlantType.Desert
            || plantType === EnumPlantType.Plains
            || plantType === EnumPlantType.Cave
    }

}

abstract class AbstractOvergrownItemBlock(name: String, block: Block) : ItemBlock(block) {

    init {
        translationKey = "crocodilite.$name"
        setRegistryName(name)

        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }

}
