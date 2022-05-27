package fr.cel.flashblock.proxy;

import fr.cel.flashblock.init.ModBlocks;
import fr.cel.flashblock.init.ModEntities;
import fr.cel.flashblock.init.ModItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit(){
        super.postInit();
        ModEntities.registerEntitiesRenders();
    }

}
