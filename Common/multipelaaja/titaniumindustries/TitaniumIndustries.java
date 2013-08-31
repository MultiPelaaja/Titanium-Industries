package multipelaaja.titaniumindustries;

import java.util.logging.Level;

import multipelaaja.titaniumindustries.handlers.BlockHandler;
import multipelaaja.titaniumindustries.handlers.CraftingHandler;
import multipelaaja.titaniumindustries.handlers.GuiHandler;
import multipelaaja.titaniumindustries.proxy.CommonProxy;
import multipelaaja.titaniumindustries.reference.Reference;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version =  Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTEDMINECRAFTVERSIONS, dependencies = Reference.DEPENDENCIES)
@NetworkMod(serverSideRequired = false, clientSideRequired = true)
public class TitaniumIndustries {

public static int blockMachineCasingID;
public static int blockTIChestID;

@Instance(Reference.MODNAME)
public static TitaniumIndustries instance;

@SidedProxy(clientSide = "multipelaaja.titaniumindustries.proxy.ClientProxy", serverSide = "multipelaaja.titaniumindustries.proxy.CommonProxy")
public static CommonProxy proxy;

@EventHandler
public void preInit(FMLPreInitializationEvent event){
	FMLLog.log(Level.INFO, "[Titanium Industries] Initialization Started!");
	
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	
    try {
        config.load();
        blockMachineCasingID = config.getBlock("Machine Casing", 500).getInt(500);
        blockTIChestID = config.getBlock("TI Chest", 501).getInt(501);
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

//	BlockHandler.createConfiguration(new Configuration(), new FMLPreInitializationEvent());
	BlockHandler.createBlocks();
	BlockHandler.registerBlocks(new GameRegistry());
	BlockHandler.setBlockName(new LanguageRegistry());
	BlockHandler.registerMiningLevel(new MinecraftForge());
//	TileEntityHandler.registerTileEntity(new GameRegistry());
	CraftingHandler.addRecipes(new GameRegistry());
//	GuiHandler.registerGUI(new NetworkRegistry());
}

@EventHandler
public void init(FMLInitializationEvent event){	
	}

@EventHandler
public void postInit(FMLPostInitializationEvent event){
	}

}