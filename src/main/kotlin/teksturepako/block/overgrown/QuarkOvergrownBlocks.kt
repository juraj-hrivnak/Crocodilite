package teksturepako.block.overgrown

import net.minecraft.block.Block
import net.minecraft.init.Blocks
import panda.divergentunderground.integration.QuarkCompat.HARD_LIMESTONE
import panda.divergentunderground.integration.QuarkCompat.HARD_MARBLE

// Prevent crash when Quark is not loaded
fun returnBlock(name: String): Block {
    return try {
        when (name) {
            "HARD_MARBLE" -> HARD_MARBLE
            "HARD_LIMESTONE" -> HARD_LIMESTONE
            else -> Blocks.AIR
        }
    } catch (e: NoClassDefFoundError) {
        Blocks.AIR
    }
}

// Marble
val BlockOvergrownMarble = object : AbstractOvergrown("overgrown_marble", returnBlock("HARD_MARBLE")) {}
val ItemBlockOvergrownMarble = object : AbstractOvergrownItemBlock("overgrown_marble", BlockOvergrownMarble) {}

// Limestone
val BlockOvergrownLimestone = object : AbstractOvergrown("overgrown_limestone", returnBlock("HARD_LIMESTONE")) {}
val ItemBlockOvergrownLimestone = object : AbstractOvergrownItemBlock("overgrown_limestone", BlockOvergrownLimestone) {}

