package fr.cel.flashblock.tab;

import fr.cel.flashblock.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FlashblockTab extends CreativeTabs {

    public FlashblockTab(int index, String label){
        super(index, label);
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.flashblockLogo;
    }

}
