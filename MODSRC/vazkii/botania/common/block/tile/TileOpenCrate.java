/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [May 4, 2014, 12:51:05 PM (GMT)]
 */
package vazkii.botania.common.block.tile;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import vazkii.botania.common.lib.LibBlockNames;

public class TileOpenCrate extends TileSimpleInventory {

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public String getInventoryName() {
		return LibBlockNames.OPEN_CRATE;
	}

	@Override
	public void updateEntity() {
		Block blockBelow = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
		if(blockBelow.isAir(worldObj, xCoord, yCoord - 1, zCoord)) {
			ItemStack stack = getStackInSlot(0);
			if(stack != null) {
				EntityItem item = new EntityItem(worldObj, xCoord + 0.5, yCoord - 0.5, zCoord + 0.5, stack);
				item.motionX = 0;
				item.motionY = 0;
				item.motionZ = 0;
				setInventorySlotContents(0, null);
				if(!worldObj.isRemote)
					worldObj.spawnEntityInWorld(item);
			}
		}
	}


}
