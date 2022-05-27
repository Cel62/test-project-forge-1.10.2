package fr.cel.flashblock.entity.render;

import fr.cel.flashblock.entity.EntityRobotPig;
import fr.cel.flashblock.util.References;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRobotPig extends RenderLiving<EntityRobotPig> {

    private ResourceLocation texture = new ResourceLocation(References.MODID, "textures/entity/robotpig/texture.png");

    public RenderRobotPig(RenderManager renderManagerIn){
        super(renderManagerIn, new ModelPig(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRobotPig entity) {
        return getEntityResourceLocation();
    }

    private ResourceLocation getEntityResourceLocation(){
        return texture;
    }

}
