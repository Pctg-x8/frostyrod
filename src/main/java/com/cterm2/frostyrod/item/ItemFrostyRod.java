package com.cterm2.frostyrod.item;

import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

// Main item class of Frosty Rod
public class ItemFrostyRod extends Item
{
	public ItemFrostyRod()
	{
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
				System.out.println("Item used to " + blockState.getBlock());
			}
			return true;
		}
	}
}
