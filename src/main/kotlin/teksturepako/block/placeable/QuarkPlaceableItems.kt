package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import panda.divergentunderground.integration.QuarkCompat.ROCK_LIMESTONE
import panda.divergentunderground.integration.QuarkCompat.ROCK_MARBLE

// Prevent crash when Quark is not loaded
fun returnItem(name: String): Item {
    return try {
        when (name) {
            "ROCK_MARBLE" -> ROCK_MARBLE
            "ROCK_LIMESTONE" -> ROCK_LIMESTONE
            else -> {
                Items.AIR
            }
        }
    } catch (e: NoClassDefFoundError) {
        Items.AIR
    }
}

// TODO: Item blocks don't work, fix them

// Marble Rock
val BlockMarbleRock: Block =
    object : AbstractPlaceableItem("rock_marble", returnItem("ROCK_MARBLE"), SoundType.STONE) {}
val ItemBlockMarbleRock: ItemBlock =
    object : AbstractPlaceableItemBlock("rock_marble", returnItem("ROCK_MARBLE"), BlockMarbleRock) {}

// Limestone Rock
val BlockLimestoneRock: Block =
    object : AbstractPlaceableItem("rock_limestone", returnItem("ROCK_LIMESTONE"), SoundType.STONE) {}
val ItemBlockLimestoneRock: ItemBlock =
    object : AbstractPlaceableItemBlock("rock_limestone", returnItem("ROCK_LIMESTONE"), BlockLimestoneRock) {}
