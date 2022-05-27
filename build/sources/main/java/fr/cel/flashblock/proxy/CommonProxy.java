package fr.cel.flashblock.proxy;

import fr.cel.flashblock.events.DeathTouchEvent;
import fr.cel.flashblock.gen.OreGeneration;
import fr.cel.flashblock.init.ModBlocks;
import fr.cel.flashblock.init.ModEnchantments;
import fr.cel.flashblock.init.ModItems;
import fr.cel.flashblock.init.ModRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit() {
        new ModItems();
        new ModBlocks();
        new ModEnchantments();
    }

    public void init() {
        new ModRecipes();
        GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
        MinecraftForge.EVENT_BUS.register(new DeathTouchEvent());
    }

}