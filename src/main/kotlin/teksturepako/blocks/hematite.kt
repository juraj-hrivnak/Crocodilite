package teksturepako.blocks

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import java.util.*


val itemCompressedCobble : Item = object : Item() {
    init {
        setRegistryName("item_kokos")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}

val blockCompressedCobble: Block = object : Block(Material.ROCK) {
    init {
        setRegistryName("compressed_cobblestone")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
        setHardness(3F)
        setResistance(15F)
        soundType = SoundType.STONE
    }

    override fun getItemDropped(state: IBlockState?, rand: Random?, fortune: Int): Item {
        return itemCompressedCobble
    }
}

val itemBlockCompressedCobble : ItemBlock = object : ItemBlock(blockCompressedCobble) {
    init {
        setRegistryName("compressed_cobblestone")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}
