package com.cterm2.frostyrod.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

// Main item class of Frosty Rod
public class ItemFrostyRod extends Item
{
	public ItemFrostyRod()
	{
		// Cannot stack
		this.setUnlocalizedName("frostyRod");
		this.setMaxStackSize(1);
	}

	// Called when item used by player
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos,
	                         EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote) return true;
		else
		{
			// Actual processing only in server
			IBlockState blockState = world.getBlockState(pos);
			if(blockState != null)
			{
				Block block = blockState.getBlock();
				if(block == Blocks.dirt || block == Blocks.grass)
				{
					// To dirt or grass: freeze target block
					this.freeze((EntityPlayerMP)player, world, pos);
				}
			}
			return true;
		}
	}

	// Freeze block
	private void freeze(EntityPlayerMP player, World world, BlockPos pos)
	{
		// Because executed in server, tell to client to spawn particles
		player.playerNetServerHandler.sendPacket(new S2APacketParticles(EnumParticleTypes.EXPLOSION_NORMAL, true,
				pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 0.0f, 0.0f, 0.0f, 0.1f, 20, new int[0]));
		// Place ice block with notifying
		world.setBlockState(pos, Blocks.ice.getDefaultState(), 3);
	}
}
