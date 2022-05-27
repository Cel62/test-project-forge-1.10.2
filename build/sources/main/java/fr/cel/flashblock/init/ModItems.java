package fr.cel.flashblock.init;

import fr.cel.flashblock.Flashblock;
import fr.cel.flashblock.items.ItemMeta;
import fr.cel.flashblock.items.RedSteak;
import fr.cel.flashblock.items.TestSword;
import fr.cel.flashblock.items.testArmor.TestBoots;
import fr.cel.flashblock.items.testArmor.TestChestplate;
import fr.cel.flashblock.items.testArmor.TestHelmet;
import fr.cel.flashblock.items.testArmor.TestLeggings;
import fr.cel.flashblock.utils.References;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    public ModItems() {
        initItems();
        registerItems();
        registerRenders();
    }

    /**
     * Pour add des items :
     * l'ajouter comme ci-dessous,
     * le mettre dans initItems(),
     * le mettre dans registersItems()
     * et le mettre dans registerRenders(),
     * faire son json dans models/item
     * et faire sa texture dans textures/items
     */
    public static Item flashblockLogo, itemMeta, redSteak;
    public static Item test_helmet, test_chestplate, test_leggings, test_boots;
    public static final Item testSword = new TestSword("test_sword", ToolMaterials.testMat);

    // c'est ici que j'initialise l'item
    public void initItems() {
        flashblockLogo = new Item().setRegistryName("flashblockLogo").setUnlocalizedName("flashblockLogo").setCreativeTab(Flashblock.tab);
        itemMeta = new ItemMeta("itemMeta");
        redSteak = new RedSteak();

        // Test Armor
        test_helmet = new TestHelmet("test_helmet", ArmorMaterials.testMat, 2, EntityEquipmentSlot.HEAD);
        test_chestplate = new TestChestplate("test_chestplate", ArmorMaterials.testMat, 2, EntityEquipmentSlot.CHEST);
        test_leggings = new TestLeggings("test_leggings", ArmorMaterials.testMat, 2, EntityEquipmentSlot.LEGS);
        test_boots = new TestBoots("test_boots", ArmorMaterials.testMat, 2, EntityEquipmentSlot.FEET);
    }

    // c'est ici que j'ajoute l'item
    public void registerItems() {
        registerItem(flashblockLogo);
        registerItem(itemMeta);
        registerItem(redSteak);

        // Test Armor
        registerItem(test_helmet);
        registerItem(test_chestplate);
        registerItem(test_leggings);
        registerItem(test_boots);

        registerItem(testSword);
    }

    // c'est ici que j'ajoute le render de l'item
    @SideOnly(Side.CLIENT)
    public void registerRenders() {
        registerRender(flashblockLogo, 0);
        registerRender(redSteak, 0);

        registerRender(itemMeta, 0);
        registerRender(itemMeta, 1);
        registerRender(itemMeta, 2);

        registerRender(test_helmet, 0);
        registerRender(test_chestplate, 0);
        registerRender(test_leggings, 0);
        registerRender(test_boots, 0);

        registerRender(testSword, 0);
    }

    /*----------------------------------------------------------------------------------------------------------------*/

    // méthode pour add l'item
    private void registerItem(Item item) {
        GameRegistry.register(item);
    }

    // méthode pour add le render de l'item
    private void registerRender(Item item, int meta) {
        if (meta == 0) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
        } else {
            ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5) + meta), "inventory"));
        }
    }

    public static class ArmorMaterials {
        public static final ItemArmor.ArmorMaterial testMat = EnumHelper.addArmorMaterial("testArmorMat", References.MODID + ":testArmor", 230, new int[]{2, 4, 5, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
    }

    public static class ToolMaterials {

        public static final Item.ToolMaterial testMat = EnumHelper.addToolMaterial("testMat", 3, 2000, 8.0F, 3.0F, 22);

    }

}