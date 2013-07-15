package multipelaaja.titanium_industries;

import multipelaaja.titanium_industries.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version =  Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTEDMINECRAFTVERSIONS, dependencies = Reference.DEPENDENCIES)
@NetworkMod(serverSideRequired = false, clientSideRequired = true)
public class TitaniumIndustries {

@Instance(Reference.MOD_NAME)
public static TitaniumIndustries instance;

@SidedProxy(clientSide = "multipelaaja.titanium_industries.proxy.ClientProxy", serverSide = "multipelaaja.titanium_industries.proxy.CommonProxy")
public static CommonProxy proxy;

@EventHandler
public void preInit(FMLPreInitializationEvent event){
	
}

@EventHandler
public void init(FMLInitializationEvent event){
	
}

@EventHandler
public void postInit(FMLPostInitializationEvent event){
	
}

}
