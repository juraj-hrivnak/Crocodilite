package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.item.ItemBlock
import net.minecraft.util.ResourceLocation


val BlockStick : Block = object : AbstractPlaceableItem("stick") {
    init {
        soundType = SoundType.WOOD
    }

    override val itemResourceLocation = ResourceLocation("minecraft", "stick")
}

val ItemBlockStick : ItemBlock = object : ItemBlock(BlockStick) {
    init {
        this.registryName = ResourceLocation("minecraft", "stick")
    }
}

