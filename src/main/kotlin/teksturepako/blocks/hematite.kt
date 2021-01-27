package teksturepako.blocks

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import java.util.*


val itemCrocodilite : Item = object : Item() {
    init {
        setRegistryName("crocodilite")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}

val blockCrocodilite: Block = object : Block(Material.ROCK) {
    init {
        setRegistryName("crocodilite_block")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
        setHardness(3F)
        setResistance(15F)
        soundType = SoundType.STONE
    }

    override fun getItemDropped(state: IBlockState?, rand: Random?, fortune: Int): Item {
        return itemCrocodilite
    }
}

val itemBlockCrocodilite : ItemBlock = object : ItemBlock(blockCrocodilite) {
    init {
        setRegistryName("crocodilite_block")
    }
}
