package fr.cel.flashblock.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentDeathTouch extends Enchantment {

    public EnchantmentDeathTouch(String name) {
        super(Rarity.COMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{});
        this.isAllowedOnBooks();

        this.setRegistryName(name);
        this.setName(name);
    }

    // level minimum
    @Override
    public int getMinLevel() {
        return 1;
    }

    // level maximum
    @Override
    public int getMaxLevel() {
        return 1;
    }

    // on doit utiliser combien de levels au mini ?
    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 20;
    }

    // on doit utiliser combien de levels au maxi ?
    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 30;
    }
}
