package fr.cel.flashblock.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlock extends TileEntity {

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        if(!compound.hasKey("clicks")){
            compound.setInteger("clicks", 0);
        }

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {

        if(compound.hasKey("clicks")){
            compound.setInteger("clicks", compound.getInteger("clicks"));
        }

        return compound;
    }

    public void increaseClicksValue(){
        getTileData().setInteger("clicks", getTileData().getInteger("clicks") + 1);
    }

    public int getClicksValue(){
        return getTileData().getInteger("clicks");
    }

}
