package teksturepako.block.placeable

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumFacing
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import panda.divergentunderground.DivergentUnderground


val BlockQuartziteRock : Block = object : AbstractPlaceableItem("quartzite_rock") {

    init {
        soundType = SoundType.STONE
        creativeTab = DivergentUnderground.Tab
    }

    override val itemResourceLocation = ResourceLocation("divergentunderground", "rock_stone")
}

val ItemBlockQuartziteRock : ItemBlock = object : ItemBlock(BlockQuartziteRock) {
    init {
        this.registryName = ResourceLocation("divergentunderground", "rock_stone")
        creativeTab = DivergentUnderground.Tab
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
