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

        if (e.getEntityPlayer() != null) {
            EntityPlayer player = e.getEntityPlayer();

            if (player.getHeldItem(EnumHand.MAIN_HAND) != null) {
                ItemStack item = player.getHeldItem(EnumHand.MAIN_HAND);

                if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.death_touch, item) == 1) {
                    if (e.getTarget() != null) {
                        Entity entity = e.getTarget();

                        if (entity instanceof EntityLiving) {
                            ((EntityLiving) entity).setHealth(0f);
                        }
                    }
                }

            }
        }

    }

}