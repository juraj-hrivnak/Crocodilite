package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.init.Items
import net.minecraft.item.ItemBlock
import panda.divergentunderground.init.ModItems.*

// Quartzite Rock
val BlockQuartziteRock: Block =
    object : AbstractPlaceableItem("quartzite_rock", ROCK_STONE, SoundType.STONE) {}
val ItemBlockQuartziteRock: ItemBlock =
    object : AbstractPlaceableItemBlock("quartzite_rock", ROCK_STONE, BlockQuartziteRock) {}

// Stick
val BlockStick: Block =
    object : AbstractPlaceableItem("stick", Items.STICK, SoundType.WOOD) {}
val ItemBlockStick: ItemBlock =
    object : AbstractPlaceableItemBlock("stick", Items.STICK, BlockStick) {}
