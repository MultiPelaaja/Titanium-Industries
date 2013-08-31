package multipelaaja.titaniumindustries.gui.handler;

import multipelaaja.titaniumindustries.TitaniumIndustries;
import multipelaaja.titaniumindustries.container.ContainerTIChest;
import multipelaaja.titaniumindustries.gui.GuiTIChest;
import multipelaaja.titaniumindustries.tileentity.TileEntityTIChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.IGuiHandler;

public class TIChestGuiHandler implements IGuiHandler {
       
	//returns an instance of the Container you made earlier

        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                
        	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityTIChest){
                        return new ContainerTIChest(player.inventory, (TileEntityTIChest) tileEntity);
                }
                return null;
        }

        //returns an instance of the Gui you made earlier

        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                
        	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityTIChest){
                        return new GuiTIChest(player.inventory, (TileEntityTIChest) tileEntity);
                }
                
                FMLNetworkHandler.openGui(player, TitaniumIndustries.instance, 0, world, x, y, z);
                	return null;				
        }
}
