package multipelaaja.titaniumindustries.blocks;

import multipelaaja.titaniumindustries.creativetab.TitaniumIndustriesTab;
import multipelaaja.titaniumindustries.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreTitanium extends Block{
		
	public OreTitanium(int id){
			super(id, Material.rock);
			this.setCreativeTab(TitaniumIndustriesTab.TitaniumIndustriesTab);
			this.setResistance(6F);
			this.setHardness(5F);
			this.setUnlocalizedName("TITitaniumOre");
			this.setStepSound(soundStoneFootstep);
}
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister par1IconRegister) {
    this.blockIcon = par1IconRegister.registerIcon(Reference.MODID + ":" + "TitaniumOre");
	}
}