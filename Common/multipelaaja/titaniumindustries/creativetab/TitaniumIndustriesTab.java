package multipelaaja.titaniumindustries.creativetab;

import cpw.mods.fml.common.registry.LanguageRegistry;
import multipelaaja.titaniumindustries.handlers.BlockHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TitaniumIndustriesTab extends CreativeTabs {
	
	public static final CreativeTabs TitaniumIndustriesTab = new TitaniumIndustriesTab("TitaniumIndustriesTab");

	public TitaniumIndustriesTab(String label) {
		super(label);
		
	LanguageRegistry.instance().addStringLocalization("itemGroup.TitaniumIndustriesTab", "en_US", "Titanium Industries");
	
	}

	public ItemStack getIconItemStack() {
		return new ItemStack(BlockHandler.MachineCasing); 
	}
}
