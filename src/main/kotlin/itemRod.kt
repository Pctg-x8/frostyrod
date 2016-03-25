package com.cterm2.frostyrod

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.network.play.server.S2APacketParticles
import net.minecraft.util.BlockPos
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumParticleTypes
import net.minecraft.world.World
1
// Frosty Rod Item
class ItemFrostyRod : Item()
{
    init
    {
        // cannot stack
        this.unlocalizedName = "frostyRod"
        this.maxStackSize = 1
    }

    // Called when item used by player
    override fun onItemUse(stack: ItemStack?, player: EntityPlayer?, world: World?, pos: BlockPos?,
                           side: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float) =
    {
        if(world?.isRemote == false)
        {
            // Only processed in server
            val block = world?.getBlockState(pos)?.block
            if(block == Blocks.grass || block == Blocks.dirt) this.freeze(player!! as EntityPlayerMP, world!!, pos!!)
        }
        true
    }()

    companion object {
        const val CostExperience = 1
    }

    // Freeze block consuming Experience
    private fun freeze(player: EntityPlayerMP, world: World, pos: BlockPos)
    {
        if(player.capabilities.isCreativeMode || player.experienceLevel >= CostExperience)
        {
            // using magic with consuming user's experience
            if(!player.capabilities.isCreativeMode) player.removeExperienceLevel(CostExperience)
            // Because executed in server, tell to client to spawn particles
            player.playerNetServerHandler.sendPacket(S2APacketParticles(EnumParticleTypes.EXPLOSION_NORMAL, true,
                    pos.x + 0.5f, pos.y + 0.5f, pos.z + 0.5f, 0.0f, 0.0f, 0.0f, 0.1f, 20));
            // Place ice block with notifying
            world.setBlockState(pos, Blocks.ice.defaultState, 3)
        }
    }
}
