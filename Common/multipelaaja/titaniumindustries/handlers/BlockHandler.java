package multipelaaja.titaniumindustries.handlers;

import java.util.logging.Level;

import multipelaaja.titaniumindustries.TitaniumIndustries;
import multipelaaja.titaniumindustries.blocks.BlockMachineCasing;
import multipelaaja.titaniumindustries.blocks.BlockTIChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockHandler {
	
	public static Block MachineCasing;
	public static Block TIChest;
	
	private static int blockMachineCasingID;
	private static int blockTIChestID;

/**
 * Makes Configuration
 * @param config
 * @param event
 */
	@Deprecated
	public static void createConfiguration(Configuration config, FMLPreInitializationEvent event) {
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		
    try {
        config.load();
        blockMachineCasingID = config.getBlock("Machine Casing", 900).getInt(900);
        blockTIChestID = config.getBlock("TI Chest", 901).getInt(901);
    }
    catch (Exception e) {
        FMLLog.log(Level.SEVERE, e, "Titanium Industries has a problem loading it's configuration");
    }
    finally {
    	if (config.hasChanged()) {
            config.save();
            FMLLog.log(Level.INFO, "[Titanium Industries] Loaded Configuration");
}
  }
	}
    
/**
 * Registers Blocks
 */
	public static void createBlocks() {
	MachineCasing = new BlockMachineCasing (TitaniumIndustries.blockMachineCasingID, Material.iron);
//	TIChest = new BlockTIChest (TitaniumIndustries.blockTIChestID, par2);
	
    FMLLog.log(Level.INFO, "[Titanium Industries] Loaded Blocks");
	
	//System.out.println("[Titanium Industries] Loaded Configuration.");
	}
	
/**
 * Registers blocks.
 * @param greg
 */
	public static void registerBlocks(GameRegistry greg) {
		greg.registerBlock(MachineCasing, "MachineCasing");
//		greg.registerBlock(TIChest, "TIChest");
		
//		System.out.println("[Titanium Industries] Registered Blocks.");
		FMLLog.log(Level.INFO, "[Titanium Industries] Registered Blocks");
	}
	
/**
 * Sets block name.	
 * @param lreg
 */
	public static void setBlockName(LanguageRegistry lreg) {
		lreg.addName(MachineCasing, "Machine Casing");
//		lreg.addName(TIChest, "Chest");
		
		FMLLog.log(Level.INFO, "[Titanium Industries] Named Blocks");
		
//		System.out.println("[Titanium Industries] Named Blocks.");
	}
	
	public static void registerMiningLevel(MinecraftForge forge) {
		forge.setBlockHarvestLevel(BlockHandler.MachineCasing, "pickaxe", 3);
		
		FMLLog.log(Level.INFO, "[Titanium Industries] Registered Recipes");
	}
	
}
