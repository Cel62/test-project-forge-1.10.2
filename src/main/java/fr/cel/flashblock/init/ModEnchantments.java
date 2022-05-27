package fr.cel.flashblock.init;

import fr.cel.flashblock.enchant.EnchantmentDeathTouch;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModEnchantments {

    public ModEnchantments(){
        registerEnchantments();
    }

    /**
    * Pour add enchant :
     * créer une classe pour l'enchant
     * le mettre comme ci-dessous
     * et le register dans registerEnchantments()
    */
    public static final Enchantment death_touch = new EnchantmentDeathTouch("death_touch");

    // add Enchant
    public static void registerEnchantments(){
        GameRegistry.register(death_touch);
    }
}
