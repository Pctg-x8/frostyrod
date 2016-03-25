package com.cterm2.frostyrod;

import com.cterm2.frostyrod.item.ItemFrostyRod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

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

		if(e.getSide() == Side.CLIENT)
		{
			// Register item model renderer
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(ID + ":itemFrostyRod", "inventory"));
		}

		GameRegistry.addShapedRecipe(new ItemStack(item, 1),
				" BA",
				" CB",
				"C  ",
				'A', new ItemStack(Blocks.ice), 'B', new ItemStack(Items.iron_ingot), 'C', new ItemStack(Items.stick));
	}
}
