package multipelaaja.titaniumindustries.handlers;

import multipelaaja.titaniumindustries.TitaniumIndustries;
import multipelaaja.titaniumindustries.gui.handler.TIChestGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler {
	public static void registerGUI (NetworkRegistry nreg){
		nreg.instance().registerGuiHandler(TitaniumIndustries.instance, new TIChestGuiHandler());
	}
}
