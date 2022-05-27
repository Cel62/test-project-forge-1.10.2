package fr.cel.flashblock.events;

import fr.cel.flashblock.init.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DeathTouchEvent {

    @SubscribeEvent
    public void onDeathTouch(AttackEntityEvent e) {

        // detect si le joueur est pas null
        if (e.getEntityPlayer() != null) {
            EntityPlayer player = e.getEntityPlayer();

            // detect si il tient l'item dans sa main principale
            if (player.getHeldItem(EnumHand.MAIN_HAND) != null) {
                ItemStack item = player.getHeldItem(EnumHand.MAIN_HAND);

                // detect si il a l'enchant Death Touch
                if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.death_touch, item) == 1) {
                    // detect si le target est pas null
                    if (e.getTarget() != null) {
                        Entity entity = e.getTarget();

                        // detect si l'entity est une EntityLiving
                        if (entity instanceof EntityLiving) {
                            ((EntityLiving) entity).setHealth(0f);
                        }
                    }
                }

            }
        }

    }

}