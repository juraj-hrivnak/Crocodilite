package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.init.Items
import net.minecraft.item.ItemBlock
import panda.divergentunderground.init.ModItems.*


// Quartzite Rock
val BlockQuartziteRock: Block = PlaceableItem("quartzite_rock", ROCK_STONE, SoundType.STONE)
val ItemBlockQuartziteRock: ItemBlock = PlaceableItemBlock("quartzite_rock", ROCK_STONE, BlockQuartziteRock)

// Stick
val BlockStick: Block = PlaceableItem("stick", Items.STICK, SoundType.WOOD)
val ItemBlockStick: ItemBlock = PlaceableItemBlock("stick", Items.STICK, BlockStick)

// Flint
val BlockFlint: Block = PlaceableItem("flint", Items.FLINT, SoundType.STONE)
val ItemBlockFlint: ItemBlock = PlaceableItemBlock("flint", Items.FLINT, BlockFlint)
