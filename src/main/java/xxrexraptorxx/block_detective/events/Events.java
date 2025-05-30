package xxrexraptorxx.block_detective.events;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import xxrexraptorxx.block_detective.main.References;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.block_detective.utils.InformationTypes;
import xxrexraptorxx.block_detective.utils.NameHelper;
import xxrexraptorxx.magmacore.utils.FormattingHelper;

import java.util.List;
import java.util.Objects;

@EventBusSubscriber(modid = References.MODID, bus = EventBusSubscriber.Bus.GAME)
public class Events {

    /**
     * Adds tooltips to items.
     **/
    @SubscribeEvent
    public static void addingToolTips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        List<Component> list = event.getToolTip();
        String separator = ": ";

        // Flag to check if the item is a block
        boolean isBlock = false;

        // Iterate over all registered blocks
        for (Block block : BuiltInRegistries.BLOCK) {
            BlockState state = block.defaultBlockState();

            // Compare the registry keys (using equals() since they are objects)
            if (BuiltInRegistries.ITEM.getKey(item).equals(BuiltInRegistries.BLOCK.getKey(block)) && Config.isBlockTooltipsEnabled()) {
                isBlock = true;

                if (!getKeyValue()) {
                    if (Config.getTooltipHintSize() != InformationTypes.HIDDEN) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "hold_" + getKeyString() + "_" + Config.getTooltipHintSize() + ".desc")
                                .withStyle(ChatFormatting.GRAY));
                    }
                } else {
                    if (Config.isRegistryNameShown() && !Minecraft.getInstance().options.advancedItemTooltips) {
                        list.add(Component.literal(BuiltInRegistries.ITEM.getKey(item).toString())
                                .withStyle(ChatFormatting.GOLD));
                    }
                    if (Config.isDestroyTimeShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "destroy_time").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.defaultDestroyTime())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isExplosionResistanceShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "explosion_resistance").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getExplosionResistance())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isJumpFactorShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "jump_factor").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getJumpFactor())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isSpeedFactorShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "speed_factor").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getSpeedFactor())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isLightLevelShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "light_level").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(state.getLightEmission())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isFrictionShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "friction").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getFriction())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isFlammableFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "flammable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.isFlammable(
                                        event.getContext().level(), new BlockPos(0, 0, 0), Direction.DOWN)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isSolidFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "solid").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.isSolid()))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isCorrectToolRequiredFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "requires_correct_tool").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.requiresCorrectToolForDrops()))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isGravityAffectedFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "is_gravity_affected").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(block instanceof FallingBlock))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isClimbableFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "climbable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.CLIMBABLE)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isMapColorShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "map_color").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.capitalizeWords(NameHelper.getMapColorName(block.defaultMapColor())))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isInstrumentShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "instrument").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.capitalizeWords(String.valueOf(state.instrument())))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isImpermeableFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "impermeable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.IMPERMEABLE)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isReplaceableFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "replaceable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.REPLACEABLE)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isAnimalSpawnableFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "animal_spawnable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.ANIMALS_SPAWNABLE_ON)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isBeaconBaseFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "beacon_base").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.BEACON_BASE_BLOCKS)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isInfiniburnFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "infiniburn").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.INFINIBURN_END) || state.is(BlockTags.INFINIBURN_NETHER) || state.is(BlockTags.INFINIBURN_OVERWORLD)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isVibrationDampeningShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "dampens_vibrations").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.is(BlockTags.DAMPENS_VIBRATIONS)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.isPathfindableFlagShown()) {
                        list.add(FormattingHelper.setModLangComponent("message", References.MODID, "pathfindable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(NameHelper.ConvertBooleanToString(state.isPathfindable(PathComputationType.LAND)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                }

                // Once the corresponding block is found, no need to continue iterating
                break;
            }
        }

        // If the item is not a block, add item-specific tooltips (only once)
        if (!isBlock && Config.isItemTooltipsEnabled()) {
            if (!getKeyValue()) {
                if (Config.getTooltipHintSize() != InformationTypes.HIDDEN) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "hold_" + getKeyString() + "_" + Config.getTooltipHintSize() + ".desc")
                            .withStyle(ChatFormatting.GRAY));
                }

            } else {
                if (Config.isRegistryNameShown() && !Minecraft.getInstance().options.advancedItemTooltips) {
                    list.add(Component.literal(BuiltInRegistries.ITEM.getKey(item).toString())
                            .withStyle(ChatFormatting.GOLD));
                }
                if (Config.isMaxSizeShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "max_size").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getMaxStackSize(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isMaxDamageShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "max_damage").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getMaxDamage(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isDamageShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "damage").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDamage(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isStoneMiningSpeedShown() && item.components().has(DataComponents.TOOL)) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "stone_mining_speed").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.STONE.defaultBlockState())))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isDirtMiningSpeedShown() && item.components().has(DataComponents.TOOL)) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "dirt_mining_speed").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.DIRT.defaultBlockState())))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isWoodMiningSpeedShown() && item.components().has(DataComponents.TOOL)) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "wood_mining_speed").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.OAK_LOG.defaultBlockState())))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isEnchantableFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "enchantable").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(Tags.Items.ENCHANTABLES)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isFoodFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "food").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(Tags.Items.FOODS)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isDyableFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "dyable").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.DYEABLE)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isBeaconPaymentFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "beacon_payment").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.BEACON_PAYMENT_ITEMS)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isTrimMaterialFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "trim_material").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.TRIM_MATERIALS)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isTrimmableFlagShown() && item.components().has(DataComponents.EQUIPPABLE)) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "trimmable").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(stack.is(ItemTags.TRIMMABLE_ARMOR)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isGrindstoneRepairableFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "grindstone_repair").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.canGrindstoneRepair(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isPiglinCurrencyFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "piglin_currency").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(item.isPiglinCurrency(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.isPiglinNeutralityFlagShown()) {
                    list.add(FormattingHelper.setModLangComponent("message", References.MODID, "piglins_neutral").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(NameHelper.ConvertBooleanToString(item.makesPiglinsNeutral(stack, Objects.requireNonNull(event.getEntity()))))
                                    .withStyle(ChatFormatting.GOLD)));
                }
            }
        }
    }



    private static boolean getKeyValue() {
        return Config.getUseCtrlInsteadOfShift() ? Screen.hasControlDown() : Screen.hasShiftDown();
    }


    private static String getKeyString() {
        return Config.getUseCtrlInsteadOfShift() ? "ctrl" : "shift";
    }

}
