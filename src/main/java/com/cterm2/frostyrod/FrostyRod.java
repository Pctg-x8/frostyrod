package com.cterm2.frostyrod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

// Mod Entry Class
@Mod(modid = FrostyRod.ID, name = FrostyRod.Name, version = FrostyRod.Version)
public class FrostyRod
{
	public static final FrostyRod instance = new FrostyRod();

	static final String ID = "frostyrod";
	static final String Name = "Frosty Rod";
	static final String Version = "1.0.0";

	// Initialize the mod
	@EventHandler
	public void init(FMLInitializationEvent e)
	{

	}
}
