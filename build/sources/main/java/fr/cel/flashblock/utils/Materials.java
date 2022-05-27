package fr.cel.flashblock.utils;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {

    public static final ItemArmor.ArmorMaterial testArmor = EnumHelper.addArmorMaterial("testArmorMat", "testArmor", 144, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

}
