package fr.cel.flashblock.item;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import fr.cel.flashblock.Flashblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class ToolDiamondDigger extends ItemTool {

    private static Set<Block> effectives = Sets.newHashSet();

    public ToolDiamondDigger(String name, ToolMaterial toolMaterial){
        super(toolMaterial, effectives);

        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(Flashblock.tab);
    }

    // pour lui dire que c'est une pioche, pelle et hache
    @Override
    public Set<String> getToolClasses(ItemStack item){
        return ImmutableSet.of("pickaxe", "spade", "axe");
    }

    // si wood, iron ou rock alors durée pour casser normal
    public float getStrVsBlock(ItemStack stack, IBlockState state){

        if(state.getMaterial() == Material.WOOD || state.getMaterial() == Material.IRON || state.getMaterial() == Material.ROCK || state.getMaterial() == Material.ANVIL){
            return this.efficiencyOnProperMaterial;
        }
        return 1f;
    }

    // pour savoir si on peut casser le bloc ou pas
    @Override
    public boolean canHarvestBlock(IBlockState state){
        return (state.getMaterial() == Material.WOOD || state.getMaterial() == Material.IRON || state.getMaterial() == Material.ROCK || state.getMaterial() == Material.ANVIL) ? true : false;
    }

}
