package xxrexraptorxx.block_detective.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import xxrexraptorxx.block_detective.main.References;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.block_detective.utils.FormattingHelper;

@JeiPlugin
public class JEIIntegration implements IModPlugin {

    private static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(References.MODID, "jei_plugin");


    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }


    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        if (Config.ENABLE_JEI_BLOCK_PAGES.get()) {
            for (Block block : BuiltInRegistries.BLOCK) {

                registry.addIngredientInfo(new ItemStack(block), VanillaTypes.ITEM_STACK, FormattingHelper.getPageDescription(block));
            }
        }
        if (Config.ENABLE_JEI_ITEM_PAGES.get()) {
            for (Item item : BuiltInRegistries.ITEM) {

                registry.addIngredientInfo(new ItemStack(item), VanillaTypes.ITEM_STACK, FormattingHelper.getPageDescription(item));
            }
        }
    }

}