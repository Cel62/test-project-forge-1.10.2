package fr.cel.flashblock.init;

import fr.cel.flashblock.Flashblock;
import fr.cel.flashblock.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public ModBlocks(){
        initBlocks();
        registersBlocks();
        registerItemBlocks();
        registerRenders();
    }

    /**
     * Pour add des blocks :
     * l'ajouter comme ci-dessous
     * le mettre dans initBlocks()
     * le mettre dans registersBlocks()
     * le mettre dans registerRenders()
     * et le mettre dans registerItemBlocks()
     * faire son json dans models/block et models/item
     * et faire sa texture dans textures/blocks
     */
    public static Block testBlock;

    private void initBlocks() {
        testBlock = new Block(Material.ROCK).setHardness(2.0F).setResistance(10.0F).setRegistryName("testBlock").setUnlocalizedName("testBlock").setCreativeTab(Flashblock.tab);
    }

    private void registersBlocks() {
        register(testBlock);
    }

    @SideOnly(Side.CLIENT)
    private void registerRenders() {
        registerRender(testBlock, 0);
    }

    private void registerItemBlocks() {
        registerItemBlock(testBlock);
    }

    /*----------------------------------------------------------------------------------------------------------------*/

    private void register(Block block) {
        GameRegistry.register(block);
    }

    private void registerRender(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }

    private void registerItemBlock(Block block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        GameRegistry.register(itemBlock);
    }

}
