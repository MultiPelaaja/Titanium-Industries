package multipelaaja.titaniumindustries.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHandler {

	public static void addRecipes(GameRegistry greg) {
		greg.addRecipe(new ItemStack(BlockHandler.MachineCasing, 8), new Object[] {
			"GCG",
			"CDC",
			"GCG",
			'G',Block.blockGold, 'C', Block.blockIron, 'D', Block.blockDiamond
		});
	}
}
