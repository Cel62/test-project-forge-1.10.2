package fr.cel.flashblock.creativetab;

import fr.cel.flashblock.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FlashblockTab extends CreativeTabs {

    public FlashblockTab(){
        super(CreativeTabs.getNextID(), "flashblock");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.flashblockLogo;
    }

}
