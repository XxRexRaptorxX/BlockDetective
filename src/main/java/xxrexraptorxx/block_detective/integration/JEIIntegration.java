package xxrexraptorxx.block_detective.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
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
        String textSeparator = ": ";
        String lineSeperator = "\n";

        if (Config.ENABLE_JEI_ITEM_PAGES.get()) {
            for (Block block : BuiltInRegistries.BLOCK) {
                MutableComponent description = Component.literal(BuiltInRegistries.ITEM.getKey(block.asItem()).toString())
                        .append(lineSeperator);

                if (Config.SHOW_DESTROY_TIME_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.destroy_time").append(textSeparator + block.defaultDestroyTime()));
                }
                if (Config.SHOW_EXPLOSION_RESISTANCE_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.explosion_resistance").append(textSeparator + block.getExplosionResistance()));
                }
                if (Config.SHOW_JUMP_FACTOR_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.jump_factor").append(textSeparator + block.getJumpFactor()));
                }
                if (Config.SHOW_SPEED_FACTOR_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.speed_factor").append(textSeparator + block.getSpeedFactor()));
                }
                if (Config.SHOW_LIGHT_LEVEL_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.light_level").append(textSeparator + block.defaultBlockState().getLightEmission()));
                }
                if (Config.SHOW_FRICTION_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.friction").append(textSeparator + block.getFriction()));
                }
                if (Config.SHOW_IF_SOLID_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.solid").append(textSeparator).append(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().isSolid())));
                }
                if (Config.SHOW_REQUIRES_CORRECT_TOOL_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.requires_correct_tool").append(textSeparator).append(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().requiresCorrectToolForDrops())));
                }
                if (Config.SHOW_IS_GRAVITY_AFFECTED_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.is_gravity_affected").append(textSeparator).append(FormattingHelper.ConvertBooleanToString(block instanceof FallingBlock)));
                }
                if (Config.SHOW_MAP_COLOR_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.map_color").append(textSeparator + (FormattingHelper.FormatRegistryNames(FormattingHelper.getMapColorName(block.defaultMapColor())))));
                }
                if (Config.SHOW_INSTRUMENT_IN_JEI.get()) {
                    description = description.append(lineSeperator)
                            .append(Component.translatable("message.block_detective.instrument").append(textSeparator + (FormattingHelper.FormatRegistryNames(String.valueOf(block.defaultBlockState().instrument())))));
                }

                description = description.append(lineSeperator + lineSeperator)
                                .append(Component.translatable("message.block_detective.information").append(References.NAME));

                registry.addIngredientInfo(new ItemStack(block), VanillaTypes.ITEM_STACK, description.withStyle(ChatFormatting.DARK_GRAY));
            }
        }
    }

}