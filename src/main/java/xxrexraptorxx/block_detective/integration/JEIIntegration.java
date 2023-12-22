package xxrexraptorxx.block_detective.integration;

//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.registration.IRecipeRegistration;
//import mezz.jei.api.runtime.IIngredientManager;
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.Block;
//import net.minecraftforge.registries.ForgeRegistries;
//import xxrexraptorxx.block_detective.main.References;
//import xxrexraptorxx.block_detective.utils.Config;
//import xxrexraptorxx.block_detective.utils.FormattingHelper;
//
//@JeiPlugin        TODO!
//public class JEIIntegration implements IModPlugin {
//
//    private static final ResourceLocation ID = new ResourceLocation(References.MODID, "jei_plugin");
//
//    @Override
//    public ResourceLocation getPluginUid() {
//        return ID;
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registry) {
//        IIngredientManager ingredientManager = registry.getIngredientManager();
//
//        if (Config.ENABLE_JEI_ITEM_PAGES.get()) {
//            for (Block block : ForgeRegistries.BLOCKS) {
//
//                registry.addIngredientInfo(new ItemStack(block), VanillaTypes.ITEM_STACK, Component.literal(ForgeRegistries.ITEMS.getKey(block.asItem()).toString())
//                .append("\n\n").append(Component.translatable("message.block_detective.destroy_time").append(": " + (block.defaultDestroyTime())))
//                .append("\n").append(Component.translatable("message.block_detective.jump_factor").append(": " + (block.getJumpFactor())))
//                .append("\n").append(Component.translatable("message.block_detective.speed_factor").append(": " + (block.getSpeedFactor())))
//                .append("\n").append(Component.translatable("message.block_detective.light_level").append(": " + (block.defaultBlockState().getLightEmission())))
//                .append("\n").append(Component.translatable("message.block_detective.friction").append(": " + (block.getFriction())))
//                //.append("\n").append(Component.translatable("message.block_detective.flammable").append(": ").append(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().getMaterial().isFlammable())))
//                //.append("\n").append(Component.translatable("message.block_detective.solid").append(": ").append(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().getMaterial().isSolid())))
//                    .withStyle(ChatFormatting.DARK_GRAY));
//
//            }
//        }
//    }
//}