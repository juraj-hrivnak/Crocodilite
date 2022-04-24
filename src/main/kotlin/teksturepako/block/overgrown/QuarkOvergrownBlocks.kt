package teksturepako.block.overgrown

import net.minecraft.block.Block
import net.minecraft.init.Blocks
import panda.divergentunderground.integration.QuarkCompat.HARD_MARBLE
import panda.divergentunderground.integration.QuarkCompat.HARD_LIMESTONE
import vazkii.quark.world.feature.RevampStoneGen.slate
import vazkii.quark.world.feature.RevampStoneGen.jasper

// Prevent crash when Quark is not loaded
fun returnBlock(name: String): Block {
    return try {
        when (name) {
            "HARD_MARBLE" -> HARD_MARBLE
            "HARD_LIMESTONE" -> HARD_LIMESTONE
            "SLATE" -> slate
            "JASPER" -> jasper
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

// Slate
val BlockOvergrownSlate = object : AbstractOvergrown("overgrown_slate", returnBlock("SLATE")) {}
val ItemBlockOvergrownSlate = object : AbstractOvergrownItemBlock("overgrown_slate", BlockOvergrownSlate) {}

// Jasper
val BlockOvergrownJasper = object : AbstractOvergrown("overgrown_jasper", returnBlock("JASPER")) {}
val ItemBlockOvergrownJasper = object : AbstractOvergrownItemBlock("overgrown_jasper", BlockOvergrownJasper) {}
