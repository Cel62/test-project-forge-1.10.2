package fr.cel.flashblock.block;

import fr.cel.flashblock.Flashblock;
import fr.cel.flashblock.block.tileentity.TileEntityBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTileEntity extends Block implements ITileEntityProvider {

    public BlockTileEntity(String name, Material materialIn) {
        super(materialIn);

        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        this.setHardness(5f);
        this.setCreativeTab(Flashblock.tab);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityBlock();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity != null && tileEntity instanceof TileEntityBlock) {

                TileEntityBlock te = (TileEntityBlock) tileEntity;

                te.increaseClicksValue();
                worldIn.getMinecraftServer().getPlayerList().sendChatMsg(new TextComponentString("" + te.getClicksValue()));
                return true;
            }

        }
        return true;
    }

}