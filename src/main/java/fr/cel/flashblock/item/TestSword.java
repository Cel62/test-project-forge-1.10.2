package fr.cel.flashblock.item;

import fr.cel.flashblock.Flashblock;
import fr.cel.flashblock.creativetab.FlashblockCreativeTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestSword extends ItemSword {
    public TestSword(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(FlashblockCreativeTabs.FLASHBLOCK);
    }

    // detect si on fait click droit -> give 5 apples et enlève de la durabilité à l'item
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        int damages = 3;

        // detect si on est en solo
        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.APPLE, 5)));
            stack.damageItem(damages, player);
        }
        return super.onItemRightClick(stack, world, player, hand);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

            if (worldIn.getBlockState(pos) != null) {

                IBlockState blockState = worldIn.getBlockState(pos);

                if (blockState.getBlock() == Blocks.STONE) {

                    if (!worldIn.isRemote) {
                        worldIn.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
                    } else {
                        worldIn.spawnParticle(EnumParticleTypes.CRIT, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 0.5f, 0.5f, 0.5f);
                        worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1f, 1f);
                    }
                    return EnumActionResult.SUCCESS;
                }
            }
        return EnumActionResult.SUCCESS;
    }
}