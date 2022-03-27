package teksturepako

import com.ferreusveritas.dynamictrees.systems.DirtHelper
import net.minecraft.block.Block
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.client.renderer.color.BlockColors
import net.minecraft.client.renderer.color.IBlockColor
import net.minecraft.client.renderer.color.IItemColor
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.ColorizerGrass
import net.minecraft.world.IBlockAccess
import net.minecraft.world.biome.BiomeColorHelper
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import teksturepako.block.overgrown.*
import teksturepako.block.placeable.*


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
    const val VERSION = "2.4"
    const val DEPENDENCIES =
        "required-after:forgelin@[1.8.4,);required-after:divergentunderground;after:dynamictrees;after:quark"
    const val ACCEPTED_MINECRAFT_VERSIONS = "[1.12,1.12.2,)"

    fun isQuarkLoaded(): Boolean = (Loader.isModLoaded("quark"))
    fun isDynamicTreesLoaded(): Boolean = (Loader.isModLoaded("dynamictrees"))

    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {}

    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {

    }

    @Mod.EventBusSubscriber
    object RegistryHandler {

        // Items
        val modItems = arrayOf(
            ItemBlockOvergrownGranite,
            ItemBlockOvergrownDiorite,
            ItemBlockOvergrownAndesite,

            ItemBlockQuartziteRock,
            ItemBlockStick
        )
        val modItemsQuark = arrayOf(
            ItemBlockOvergrownMarble,
            ItemBlockOvergrownLimestone
        )

        // Blocks
        val modBlocks = arrayOf(
            BlockOvergrownGranite,
            BlockOvergrownDiorite,
            BlockOvergrownAndesite,

            BlockQuartziteRock,
            BlockStick
        )
        val modBlocksQuark = arrayOf(
            BlockOvergrownMarble,
            BlockOvergrownLimestone
        )


        @JvmStatic
        @SubscribeEvent
        fun registerItems(event: RegistryEvent.Register<Item>) {
            for (item in modItems) {
                event.registry.register(item)
            }
            if (isQuarkLoaded()) for (item in modItemsQuark) {
                event.registry.register(item)
            }
        }

        @JvmStatic
        @SubscribeEvent
        fun registerBlocks(event: RegistryEvent.Register<Block>) {
            for (block in modBlocks) {
                event.registry.register(block)
            }
            if (isQuarkLoaded()) for (block in modBlocksQuark) {
                event.registry.register(block)
            }

            if (isDynamicTreesLoaded()) {
                DirtHelper.registerSoil(BlockOvergrownGranite, DirtHelper.DIRTLIKE)
                DirtHelper.registerSoil(BlockOvergrownDiorite, DirtHelper.DIRTLIKE)
                DirtHelper.registerSoil(BlockOvergrownAndesite, DirtHelper.DIRTLIKE)
                if (isQuarkLoaded()) {
                    DirtHelper.registerSoil(BlockOvergrownMarble, DirtHelper.DIRTLIKE)
                    DirtHelper.registerSoil(BlockOvergrownLimestone, DirtHelper.DIRTLIKE)
                }
            }
        }

        @SideOnly(Side.CLIENT)
        @JvmStatic
        @SubscribeEvent
        fun registerModels(event: ModelRegistryEvent) {
            for (item in modItems) {
                ModelLoader.setCustomModelResourceLocation(
                    item, 0, ModelResourceLocation(item.registryName ?: return, "inventory")
                )
            }
            if (isQuarkLoaded()) for (item in modItemsQuark) {
                ModelLoader.setCustomModelResourceLocation(
                    item, 0, ModelResourceLocation(item.registryName ?: return, "inventory")
                )
            }
        }

        @SideOnly(Side.CLIENT)
        @JvmStatic
        @SubscribeEvent
        fun registerBlockColourHandlers(event: ColorHandlerEvent.Block) {
            val blockColors: BlockColors = event.blockColors
            val grassColourHandler = IBlockColor (
                fun(_: IBlockState?, blockAccess: IBlockAccess?, pos: BlockPos?, _: Int): Int {
                    return if (blockAccess != null && pos != null) {
                        BiomeColorHelper.getGrassColorAtPos(blockAccess, pos)
                    } else return ColorizerGrass.getGrassColor(0.5, 1.0)
                }
            )
            blockColors.registerBlockColorHandler(grassColourHandler, BlockOvergrownGranite)
            blockColors.registerBlockColorHandler(grassColourHandler, BlockOvergrownDiorite)
            blockColors.registerBlockColorHandler(grassColourHandler, BlockOvergrownAndesite)
            if (isQuarkLoaded()) {
                blockColors.registerBlockColorHandler(grassColourHandler, BlockOvergrownMarble)
                blockColors.registerBlockColorHandler(grassColourHandler, BlockOvergrownLimestone)
            }
        }

        @SideOnly(Side.CLIENT)
        @JvmStatic
        @SubscribeEvent
        fun registerItemColourHandlers(event: ColorHandlerEvent.Item) {
            val blockColors = event.blockColors
            val itemColors = event.itemColors
            val itemBlockColourHandler = IItemColor { stack: ItemStack, tintIndex: Int ->
                @Suppress("DEPRECATION")
                val state = (stack.item as ItemBlock).block.getStateFromMeta(stack.metadata)
                blockColors.colorMultiplier(state, null, null, tintIndex)
            }
            itemColors.registerItemColorHandler(itemBlockColourHandler, ItemBlockOvergrownGranite)
            itemColors.registerItemColorHandler(itemBlockColourHandler, ItemBlockOvergrownDiorite)
            itemColors.registerItemColorHandler(itemBlockColourHandler, ItemBlockOvergrownAndesite)
            if (isQuarkLoaded()) {
                itemColors.registerItemColorHandler(itemBlockColourHandler, ItemBlockOvergrownMarble)
                itemColors.registerItemColorHandler(itemBlockColourHandler, ItemBlockOvergrownLimestone)
            }

        }
    }
}
