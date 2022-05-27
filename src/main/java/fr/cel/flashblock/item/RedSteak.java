package fr.cel.flashblock.item;

import fr.cel.flashblock.Flashblock;
import net.minecraft.item.ItemFood;

public class RedSteak extends ItemFood {

    private final String name = "redSteak";
    public RedSteak(){
        super(10, 4.5f, true);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(Flashblock.tab);
    }

}