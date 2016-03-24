package com.cterm2.frostyrod;

import com.cterm2.frostyrod.item.ItemFrostyRod;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

// Mod Entry Class
@Mod(modid = FrostyRod.ID, name = FrostyRod.Name, version = FrostyRod.Version)
public class FrostyRod
{
	static final String ID = "frostyrod";
	static final String Name = "Frosty Rod";
	static final String Version = "1.0.0";

	private static final CreativeTabs ctab = new CreativeTabs(FrostyRod.ID)
	{
		@Override
		public Item getTabIconItem() { return Items.stick; }
	};
	private static final ItemFrostyRod item = new ItemFrostyRod();

	// Initialize the mod
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		GameRegistry.registerItem(item.setCreativeTab(ctab), "itemFrostyRod");
	}
}
