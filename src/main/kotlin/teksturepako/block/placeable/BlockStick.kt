package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


val BlockStick : Block = object : AbstractPlaceableItem("stick") {
    init {
        soundType = SoundType.WOOD
        creativeTab = CreativeTabs.MISC
    }

    override val itemResourceLocation = ResourceLocation("minecraft", "stick")
}

val ItemBlockStick : ItemBlock = object : ItemBlock(BlockStick) {
    init {
        this.registryName = ResourceLocation("minecraft", "stick")
        creativeTab = CreativeTabs.MISC
    }

    override fun canPlaceBlockOnSide(
        worldIn: World,
        pos: BlockPos,
        side: EnumFacing,
        player: EntityPlayer,
        stack: ItemStack
    ): Boolean {
        return player.isSneaking
    }

}

