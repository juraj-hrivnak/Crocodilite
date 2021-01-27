package teksturepako

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import teksturepako.blocks.blockCrocodilite
import teksturepako.blocks.itemBlockCrocodilite
import teksturepako.blocks.itemCrocodilite

@Mod(
    modid = Crocodilite.MOD_ID,
    name = Crocodilite.MOD_NAME,
    version = Crocodilite.VERSION,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter"
)
object Crocodilite {
    const val MOD_ID = "underdogitems"
    const val MOD_NAME = "Underdog Items"
    const val VERSION = "1.0"
    const val DEPENDENCIES = "required-after:forgelin@(1.8.4)"
    const val ACCEPTED_MINECRAFT_VERSIONS = "[1.12,1.12.2]"

    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {
    }
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
    }
    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {
    }
    @Mod.EventBusSubscriber
    object RegistryHandler {
        @JvmStatic
        @SubscribeEvent
        fun addItems(event: RegistryEvent.Register<Item>) {
            event.registry.registerAll (

                itemCrocodilite,
                itemBlockCrocodilite

//                itemCompressedCobble,
//                itemBlockCompressedCobble
            )
        }
        @JvmStatic
        @SubscribeEvent
        fun addBlocks(event: RegistryEvent.Register<Block>) {
            event.registry.registerAll (

                blockCrocodilite

//                blockCompressedCobble
            )
        }
    }
}
