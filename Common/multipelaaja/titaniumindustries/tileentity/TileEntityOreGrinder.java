package multipelaaja.titaniumindustries.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityOreGrinder extends TileEntity {
	
    public void validate() {
    	 this.tileEntityInvalid = false;
    }
    
    public void onChunkUnload() {
    	
    }

}
