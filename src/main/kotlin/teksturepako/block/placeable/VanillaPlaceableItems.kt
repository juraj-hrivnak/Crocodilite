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

// Granite Rock
val BlockGraniteRock: Block =
    object : AbstractPlaceableItem("rock_granite", ROCK_GRANITE, SoundType.STONE) {}
val ItemBlockGraniteRock: ItemBlock =
    object : AbstractPlaceableItemBlock("rock_granite", ROCK_GRANITE, BlockGraniteRock) {}

// Diorite Rock
val BlockDioriteRock: Block =
    object : AbstractPlaceableItem("rock_diorite", ROCK_DIORITE, SoundType.STONE) {}
val ItemBlockDioriteRock: ItemBlock =
    object : AbstractPlaceableItemBlock("rock_diorite", ROCK_DIORITE, BlockDioriteRock) {}

// Andesite Rock
val BlockAndesiteRock: Block =
    object : AbstractPlaceableItem("rock_andesite", ROCK_ANDESITE, SoundType.STONE) {}
val ItemBlockAndesiteRock: ItemBlock =
    object : AbstractPlaceableItemBlock("rock_andesite", ROCK_ANDESITE, BlockAndesiteRock) {}

// Stick
val BlockStick: Block =
    object : AbstractPlaceableItem("stick", Items.STICK, SoundType.WOOD) {}
val ItemBlockStick: ItemBlock =
    object : AbstractPlaceableItemBlock("stick", Items.STICK, BlockStick) {}
