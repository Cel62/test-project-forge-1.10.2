package fr.cel.flashblock.init;

import fr.cel.flashblock.Flashblock;
import fr.cel.flashblock.entity.EntityRobotPig;
import fr.cel.flashblock.entity.render.RenderRobotPig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

    private static int mobID = 0;

    public static void registerEntities() {
        EntityRegistry.registerModEntity(EntityRobotPig.class, "RobotPig", mobID++, Flashblock.instance, 60, 1, true);
    }

    @SideOnly(Side.CLIENT)
    public static void registerEntitiesRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityRobotPig.class, new RenderRobotPig(Minecraft.getMinecraft().getRenderManager()));
    }

}