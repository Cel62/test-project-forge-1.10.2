package fr.cel.flashblock.proxy;

import fr.cel.flashblock.events.DeathTouchEvent;
import fr.cel.flashblock.events.ZombieSpawnEvent;
import fr.cel.flashblock.gen.OreGeneration;
import fr.cel.flashblock.handlers.IFuelHandler;
import fr.cel.flashblock.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit() {
        new ModItems();
        new ModBlocks();
        new ModEnchantments();

        GameRegistry.registerFuelHandler(new IFuelHandler());

        ModEntities.registerEntities();
    }

    public void init() {
        new ModRecipes();
        GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
        MinecraftForge.EVENT_BUS.register(new DeathTouchEvent());
        MinecraftForge.EVENT_BUS.register(new ZombieSpawnEvent());
    }

    public void postInit(){

    }

}