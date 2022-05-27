package fr.cel.flashblock.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ZombieSpawnEvent {

    @SubscribeEvent
    public void onZombieSpawn(EntityJoinWorldEvent e) {
        World world = e.getWorld();

        // detect si on est en solo et pas multi
        if (!world.isRemote) {
            // detect si entity est pas null
            if (e.getEntity() != null) {
                Entity entity = e.getEntity();

                // detect si entity est un Zombie
                if (entity instanceof EntityZombie) {
                    world.getMinecraftServer().getPlayerList().sendChatMsg(new TextComponentString("Un zombie est apparu !"));
                }
            }
        }
    }

}
