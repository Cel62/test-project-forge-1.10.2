package fr.cel.flashblock;

import fr.cel.flashblock.proxy.CommonProxy;
import fr.cel.flashblock.creativetab.FlashblockTab;
import fr.cel.flashblock.util.References;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = "[1.10.2]")
public class Flashblock {

    public static FlashblockTab tab;

    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(References.MODID)
    public static Flashblock instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        tab = new FlashblockTab();
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){proxy.postInit();}

}