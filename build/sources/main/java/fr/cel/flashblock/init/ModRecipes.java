package fr.cel.flashblock.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public ModRecipes() {
        registerCraftRecipes();
        registerFurncaceRecipes();
        registerBrewingRecipes();
    }

    public void registerCraftRecipes() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.flashblockLogo), "SSS", "SSS", "SSS", 'S', ModItems.redSteak);
        GameRegistry.addRecipe(new ItemStack(ModItems.testSword), "F", "F", "S", 'F', ModItems.flashblockLogo, 'S', Items.STICK);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.ARROW, 50), Items.APPLE, Items.STICK, Blocks.COBBLESTONE);
    }

    public void registerFurncaceRecipes() {
        GameRegistry.addSmelting(ModItems.test_boots, new ItemStack(ModBlocks.testBlock, 5), 500f);
    }

    public void registerBrewingRecipes() {
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.testSword), new ItemStack(ModItems.redSteak, 1), new ItemStack(ModItems.flashblockLogo));
    }

}
