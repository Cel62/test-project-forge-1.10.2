package fr.cel.flashblock.creativetab;

import fr.cel.flashblock.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FlashblockCreativeTabs {

    public static final CreativeTabs FLASHBLOCK = new CreativeTabs(CreativeTabs.getNextID(), "flashblock") {
        @SideOnly(Side.CLIENT)
        @Override
        public Item getTabIconItem() {
            return ModItems.flashblockLogo;
        }
    };

}