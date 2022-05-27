package fr.cel.flashblock.handlers;

import fr.cel.flashblock.init.ModItems;
import net.minecraft.item.ItemStack;

public class IFuelHandler implements net.minecraftforge.fml.common.IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel) {

        if(fuel.getItem() == ModItems.fuelTest){
            return 200 * 5;
        }

        return 0;
    }
}