package fr.cel.flashblock.init;

import fr.cel.flashblock.enchant.EnchantmentDeathTouch;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModEnchantments {

    public ModEnchantments(){
        registerEnchantments();
    }

    public static final Enchantment death_touch = new EnchantmentDeathTouch("death_touch");

    public static void registerEnchantments(){
        GameRegistry.register(death_touch);
    }
}
