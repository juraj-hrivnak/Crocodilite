package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.item.ItemBlock
import net.minecraft.util.ResourceLocation


val BlockQuartziteRock : Block = object : AbstractPlaceableItem("quartzite_rock") {
    init {
        soundType = SoundType.STONE
    }

    override val itemResourceLocation = ResourceLocation("divergentunderground", "rock_stone")
}

val ItemBlockQuartziteRock : ItemBlock = object : ItemBlock(BlockQuartziteRock) {
    init {
        this.registryName = ResourceLocation("divergentunderground", "rock_stone")
    }
}
