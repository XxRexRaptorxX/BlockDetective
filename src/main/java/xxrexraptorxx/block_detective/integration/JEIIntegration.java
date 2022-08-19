package xxrexraptorxx.block_detective.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.resources.ResourceLocation;
import xxrexraptorxx.block_detective.main.References;

@JeiPlugin
public class JEIIntegration implements IModPlugin {

    private static final ResourceLocation ID = new ResourceLocation(References.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        IIngredientManager ingredientManager = registry.getIngredientManager();

        //TODO
        //registry.addIngredientInfo(new ItemStack(ModItems.BASIC_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.basic_wand_jei_desc"));

    }
}