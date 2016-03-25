package com.cterm2.frostyrod

import net.minecraft.client.Minecraft
import net.minecraft.client.resources.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side

@Mod(modid = FrostyRod.ID, name = FrostyRod.Name, version = FrostyRod.Version, modLanguage="kotlin")
class FrostyRod {
    companion object {
        const val ID = "frostyrod"
        const val Name = "Frosty Rod"
        const val Version = "1.0.1"

        private final val ctab = object : CreativeTabs("frostyRod")
        {
            override fun getTabIconItem() = Items.stick;
        }
        private final val item = ItemFrostyRod()
    }

    @EventHandler
    fun init(e: FMLInitializationEvent)
    {
        GameRegistry.registerItem(item.setCreativeTab(ctab), "itemFrostyRod")

        if(e.side == Side.CLIENT)
        {
            // Register item model(only required in client)
            val renderItem = Minecraft.getMinecraft().renderItem
            renderItem.itemModelMesher.register(item, 0, ModelResourceLocation(ID + ":itemFrostyRod", "inventory"))
        }

        GameRegistry.addShapedRecipe(ItemStack(item, 1),
                " BA",
                " CB",
                "C  ",
                'A', ItemStack(Blocks.ice), 'B', ItemStack(Items.iron_ingot), 'C', ItemStack(Items.stick))
    }
}
