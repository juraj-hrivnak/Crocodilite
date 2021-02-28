package teksturepako

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import java.util.*

// setRegistryName("coconut_item") doesn't need MOD_ID, It gets it automatically from the current mod that is loading
// the same thing is if you write: this.registryName = ResourceLocation(MOD_ID, "coconut_item")

val item : Item = object : Item() {
    init {
        translationKey = "coconut_item"

        setRegistryName("coconut_item")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}


val block: Block = object : Block(Material.ROCK) {
    init {
        translationKey = "coconut_block"

        setRegistryName("coconut_block")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
        setHardness(3F)
        setResistance(15F)
        soundType = SoundType.STONE
    }

    override fun getItemDropped(state: IBlockState?, rand: Random?, fortune: Int): Item {
        return item
    }
}

val itemBlock : ItemBlock = object : ItemBlock(block) {
    init {
        translationKey = "coconut_block"

        setRegistryName("coconut_block")
        creativeTab = CreativeTabs.BUILDING_BLOCKS
    }
}
