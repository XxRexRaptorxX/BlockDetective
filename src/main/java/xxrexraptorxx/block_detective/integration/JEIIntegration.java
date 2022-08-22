package xxrexraptorxx.block_detective.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import xxrexraptorxx.block_detective.main.References;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.block_detective.utils.FormattingHelper;

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

        if (Config.ENABLE_JEI_ITEM_PAGES.get()) {
            for (Block block : ForgeRegistries.BLOCKS) {

                registry.addIngredientInfo(new ItemStack(block), VanillaTypes.ITEM, new TextComponent(ForgeRegistries.ITEMS.getKey(block.asItem()).toString())
                    .append(new TextComponent("\n\nDestroy Time: " + String.valueOf(block.defaultDestroyTime())))
                    .append(new TextComponent("\nJump Factor: " + String.valueOf(block.getJumpFactor())))
                    .append(new TextComponent("\nSpeed Factor: " + String.valueOf(block.getSpeedFactor())))
                    .append(new TextComponent("\nLight Level: " + String.valueOf(block.defaultBlockState().getLightEmission())))
                    .append(new TextComponent("\nFriction: " + String.valueOf(block.getFriction())))
                    .append(new TextComponent("\nFlammable: " + FormattingHelper.ConvertBooleanToString(block.defaultBlockState().getMaterial().isFlammable())))
                    .append(new TextComponent("\nSolid: " + FormattingHelper.ConvertBooleanToString(block.defaultBlockState().getMaterial().isSolid())))
                        .withStyle(ChatFormatting.DARK_GRAY));
        }
        }
    }
}