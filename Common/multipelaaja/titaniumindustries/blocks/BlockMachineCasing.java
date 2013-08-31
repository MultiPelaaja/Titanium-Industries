package multipelaaja.titaniumindustries.blocks;

import multipelaaja.titaniumindustries.creativetab.TitaniumIndustriesTab;
import multipelaaja.titaniumindustries.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockMachineCasing extends Block{

	public BlockMachineCasing(int id, Material material) {
		super(id, material);
		this.setUnlocalizedName("TIMachineCasing");
		this.setResistance(15F);
		this.setHardness(5F);
		this.setStepSound(soundMetalFootstep);
		this.setCreativeTab(TitaniumIndustriesTab.TitaniumIndustriesTab);		
}		
		
    public boolean canCreatureSpawn(EnumCreatureType type, World world, int x, int y, int z) {
        return false;
    }
	
    public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
        return false;
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconreg) {
	    this.blockIcon = iconreg.registerIcon(Reference.MODID + ":" + "MachineCasing");
		}
}
