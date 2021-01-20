package teksturepako

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(
    modid = MinecraftForgeKotlinTemplate.MOD_ID,
    name = MinecraftForgeKotlinTemplate.MOD_NAME,
    version = MinecraftForgeKotlinTemplate.VERSION,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter"
)
object MinecraftForgeKotlinTemplate {
    const val MOD_ID = "underdogitems"
    const val MOD_NAME = "Underdog Items"
    const val VERSION = "1.0"

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {

    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    object RegistryHandler {
        @JvmStatic
        @SubscribeEvent
        fun addItems(event: RegistryEvent.Register<Item>) {
            event.registry.registerAll(itemCompressedCobble, itemBlockCompressedCobble)

        }

        @JvmStatic
        @SubscribeEvent
        fun addBlocks(event: RegistryEvent.Register<Block>) {
            event.registry.register(blockCompressedCobble)

        }
    }
}
