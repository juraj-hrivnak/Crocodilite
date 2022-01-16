package teksturepako

import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@Mod(
    modid = Crocodilite.MOD_ID,
    name = Crocodilite.MOD_NAME,
    version = Crocodilite.VERSION,
    dependencies = Crocodilite.DEPENDENCIES,
    acceptedMinecraftVersions = Crocodilite.ACCEPTED_MINECRAFT_VERSIONS,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter"
)

object Crocodilite {
    const val MOD_ID = "crocodilite"
    const val MOD_NAME = "Crocodilite"
    const val VERSION = "1.7"
    const val DEPENDENCIES = "required-after:forgelin@[1.8.4,);required-after:divergentunderground"
    const val ACCEPTED_MINECRAFT_VERSIONS = "[1.12,1.12.2,)"

    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {}

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {}

    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {}

    @Mod.EventBusSubscriber
    object RegistryHandler {

        @JvmStatic
        @SubscribeEvent
        fun registerItems(event: RegistryEvent.Register<Item>) {
            event.registry.registerAll (
                ItemBlockQuartziteRock,
                ItemBlockStick
            )
        }

        @JvmStatic
        @SubscribeEvent
        fun registerBlocks(event: RegistryEvent.Register<Block>) {
            event.registry.registerAll (
                BlockQuartziteRock,
                BlockStick
            )
        }

        @SideOnly(Side.CLIENT)
        @JvmStatic
        @SubscribeEvent
        fun registerModels(event: ModelRegistryEvent) {
            ModelLoader.setCustomModelResourceLocation(ItemBlockQuartziteRock,
                0, ModelResourceLocation(ItemBlockQuartziteRock.registryName ?: return, "inventory")
            )
            ModelLoader.setCustomModelResourceLocation(ItemBlockStick,
                0, ModelResourceLocation(ItemBlockStick.registryName ?: return, "inventory")
            )
        }
    }
}
