package multipelaaja.titaniumindustries.gui;

import multipelaaja.titaniumindustries.container.ContainerTIChest;
import multipelaaja.titaniumindustries.reference.Reference;
import multipelaaja.titaniumindustries.tileentity.TileEntityTIChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiTIChest extends GuiContainer implements IGuiHandler {

        public GuiTIChest (InventoryPlayer inventoryPlayer, TileEntityTIChest tileEntity) {
                //the container is instanciated and passed to the superclass for handling
                super(new ContainerTIChest(inventoryPlayer, tileEntity));
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                fontRenderer.drawString("Chest", 8, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        }

        @SideOnly(Side.CLIENT)
        protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
                //draw your Gui here, only thing you need to change is the path
          //	int texture = mc.renderEngine.getTexture("/gui/trap.png");
//				int texture = mc.renderEngine.getTexture("/gui/container.png");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

//              this.mc.func_110434_K().func_110577_a(Reference.MODID + "GuiTIChest");
                
//      		this.mc.renderEngine.bindTexture("/gui/trap.png");
//				this.mc.renderEngine.bindTexture("/gui/container.png");
               
                
                
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
	
			 return null;
		}

		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			// TODO Auto-generated method stub
			return null;
		}
}