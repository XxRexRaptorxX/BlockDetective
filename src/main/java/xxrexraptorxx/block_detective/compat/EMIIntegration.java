package xxrexraptorxx.block_detective.compat;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiInfoRecipe;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xxrexraptorxx.block_detective.main.References;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.block_detective.utils.NameHelper;

import java.util.List;

@EmiEntrypoint
public class EMIIntegration implements EmiPlugin {

    @Override
    public void register(EmiRegistry registry) {
        if (Config.isJeiBlockPagesEnabled()) {
            for (Block block : BuiltInRegistries.BLOCK) {
                ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(References.MODID, "info/" + BuiltInRegistries.BLOCK.getKey(block).getPath());

                registry.addRecipe(new EmiInfoRecipe(List.of(EmiStack.of(block)), List.of(NameHelper.getPageDescription(block)), recipeId));
            }
        }
        if (Config.isJeiItemPagesEnabled()) {
            for (Item item : BuiltInRegistries.ITEM) {
                ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(References.MODID, "info/" + BuiltInRegistries.ITEM.getKey(item).getPath());

                registry.addRecipe(new EmiInfoRecipe(List.of(EmiStack.of(item)), List.of(NameHelper.getPageDescription(item)), recipeId));
            }
        }
   }

}