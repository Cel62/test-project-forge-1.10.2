package fr.cel.flashblock.items;

import fr.cel.flashblock.Flashblock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemMeta extends Item {

    public static final String[] subTypes = new String[]{"1", "2", "3"};

    public ItemMeta(String name){
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHasSubtypes(true);
        this.setCreativeTab(Flashblock.tab);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        int metaData = stack.getItemDamage();

        if(metaData < 0 || metaData > subTypes.length){
            metaData = 0;
        }

        return super.getUnlocalizedName(stack) + "_" + subTypes[metaData];
    }

    @Override
    public int getMetadata(ItemStack stack) {
        int metaData = stack.getItemDamage();

        if(metaData < 0 || metaData > subTypes.length){
            metaData = 0;
        }
        return metaData;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for(int i = 0; i < subTypes.length; i++){
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}
