package multipelaaja.titaniumindustries.container;

import multipelaaja.titaniumindustries.tileentity.TileEntityTIChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTIChest extends Container {

        protected TileEntityTIChest tileEntity;

        public ContainerTIChest (InventoryPlayer inventoryPlayer, TileEntityTIChest te){
                tileEntity = te;

                //the Slot constructor takes the IInventory and the slot number in that it binds to
                //and the x-y coordinates it resides on-screen
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                                addSlotToContainer(new Slot(tileEntity, j + i * 3, 62 + j * 18, 17 + i * 18));
                        }
                }

                //commonly used vanilla code that adds the player's inventory
                bindPlayerInventory(inventoryPlayer);
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return tileEntity.isUseableByPlayer(player);
        }


        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 84 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
                }
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
                ItemStack stack = null;
                Slot slotObject = (Slot) inventorySlots.get(slot);

                //null checks and checks if the item can be stacked (maxStackSize > 1)
                if (slotObject != null && slotObject.getHasStack()) {
                        ItemStack stackInSlot = slotObject.getStack();
                        stack = stackInSlot.copy();

                        //merges the item into player inventory since its in the tileEntity
                        if (slot < 9) {
                                if (!this.mergeItemStack(stackInSlot, 9, 45, true)) {
                                        return null;
                                }
                        }
                        //places it into the tileEntity is possible since its in the player inventory
                        else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                                return null;
                        }

                        if (stackInSlot.stackSize == 0) {
                                slotObject.putStack(null);
                        } else {
                                slotObject.onSlotChanged();
                        }

                        if (stackInSlot.stackSize == stack.stackSize) {
                                return null;
                        }
                        slotObject.onPickupFromSlot(player, stackInSlot);
                }
                return stack;
        }

protected boolean mergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4)
{
    boolean flag1 = false;
    int k = par2;

    if (par4)
    {
        k = par3 - 1;
    }

    Slot slot;
    ItemStack itemstack1;

    if (par1ItemStack.isStackable())
    {
        while (par1ItemStack.stackSize > 0 && (!par4 && k < par3 || par4 && k >= par2))
        {
            slot = (Slot)this.inventorySlots.get(k);
            itemstack1 = slot.getStack();

            if (itemstack1 != null && itemstack1.itemID == par1ItemStack.itemID && (!par1ItemStack.getHasSubtypes() || par1ItemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(par1ItemStack, itemstack1))
            {
                int l = itemstack1.stackSize + par1ItemStack.stackSize;

                if (l <= par1ItemStack.getMaxStackSize())
                {
                    par1ItemStack.stackSize = 0;
                    itemstack1.stackSize = l;
                    slot.onSlotChanged();
                    flag1 = true;
                }
                else if (itemstack1.stackSize < par1ItemStack.getMaxStackSize())
                {
                    par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - itemstack1.stackSize;
                    itemstack1.stackSize = par1ItemStack.getMaxStackSize();
                    slot.onSlotChanged();
                    flag1 = true;
                }
            }

            if (par4)
            {
                --k;
            }
            else
            {
                ++k;
            }
        }
    }

    if (par1ItemStack.stackSize > 0)
    {
        if (par4)
        {
            k = par3 - 1;
        }
        else
        {
            k = par2;
        }

        while (!par4 && k < par3 || par4 && k >= par2)
        {
            slot = (Slot)this.inventorySlots.get(k);
            itemstack1 = slot.getStack();

            if (itemstack1 == null)
            {
                slot.putStack(par1ItemStack.copy());
                slot.onSlotChanged();
                par1ItemStack.stackSize = 0;
                flag1 = true;
                break;
            }

            if (par4)
            {
                --k;
            }
            else
            {
                ++k;
            }
        }
    }

    return flag1;
}
}
