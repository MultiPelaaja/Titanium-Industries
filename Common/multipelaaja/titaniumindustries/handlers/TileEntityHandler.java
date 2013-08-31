package multipelaaja.titaniumindustries.handlers;

import java.util.logging.Level;

import multipelaaja.titaniumindustries.tileentity.TileEntityTIChest;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	/**
	 * Registers TileEntityes.
	 * @param greg
	 */
	public static void registerTileEntity(GameRegistry greg) {
		
//		greg.registerTileEntity(TileEntityOreGrinder.class, "51");
//		greg.registerCraftingHandler(null);
		greg.registerTileEntity(TileEntityTIChest.class, "50");

        FMLLog.log(Level.INFO, "[Titanium Industries] Registered TileEntities");
		
//		System.out.println("[Titanium Industries] Registered TileEntities");
		}

}
