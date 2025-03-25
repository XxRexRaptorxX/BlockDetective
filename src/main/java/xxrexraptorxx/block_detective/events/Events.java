package xxrexraptorxx.block_detective.events;

import com.mojang.authlib.GameProfile;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.VersionChecker;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import xxrexraptorxx.block_detective.main.BlockDetective;
import xxrexraptorxx.block_detective.main.References;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.block_detective.utils.FormattingHelper;
import xxrexraptorxx.block_detective.utils.InformationTypes;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

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
            if (BuiltInRegistries.ITEM.getKey(item).equals(BuiltInRegistries.BLOCK.getKey(block)) && Config.ENABLE_BLOCK_TOOLTIPS.get()) {
                isBlock = true;

                if (!getKeyValue()) {
                    if (Config.TOOLTIP_HINT_SIZE.get() != InformationTypes.HIDDEN) {
                        list.add(Component.translatable("message.block_detective.hold_" + getKeyString() + "_" + Config.TOOLTIP_HINT_SIZE.get() + ".desc")
                                .withStyle(ChatFormatting.GRAY));
                    }
                } else {
                    if (Config.SHOW_REGISTRY_NAME.get() && !Minecraft.getInstance().options.advancedItemTooltips) {
                        list.add(Component.literal(BuiltInRegistries.ITEM.getKey(item).toString())
                                .withStyle(ChatFormatting.GOLD));
                    }
                    if (Config.SHOW_DESTROY_TIME.get()) {
                        list.add(Component.translatable("message.block_detective.destroy_time").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.defaultDestroyTime())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_EXPLOSION_RESISTANCE.get()) {
                        list.add(Component.translatable("message.block_detective.explosion_resistance").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getExplosionResistance())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_JUMP_FACTOR.get()) {
                        list.add(Component.translatable("message.block_detective.jump_factor").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getJumpFactor())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_SPEED_FACTOR.get()) {
                        list.add(Component.translatable("message.block_detective.speed_factor").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getSpeedFactor())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_LIGHT_LEVEL.get()) {
                        list.add(Component.translatable("message.block_detective.light_level").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(state.getLightEmission())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_FRICTION.get()) {
                        list.add(Component.translatable("message.block_detective.friction").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(String.valueOf(block.getFriction())).withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IF_FLAMMABLE.get()) {
                        list.add(Component.translatable("message.block_detective.flammable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.isFlammable(
                                        event.getEntity().level(), new BlockPos(0, 0, 0), Direction.DOWN)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IF_SOLID.get()) {
                        list.add(Component.translatable("message.block_detective.solid").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.isSolid()))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_REQUIRES_CORRECT_TOOL.get()) {
                        list.add(Component.translatable("message.block_detective.requires_correct_tool").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.requiresCorrectToolForDrops()))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_GRAVITY_AFFECTED.get()) {
                        list.add(Component.translatable("message.block_detective.is_gravity_affected").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(block instanceof FallingBlock))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_CLIMBABLE.get()) {
                        list.add(Component.translatable("message.block_detective.climbable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.CLIMBABLE)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_MAP_COLOR.get()) {
                        list.add(Component.translatable("message.block_detective.map_color").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.FormatRegistryNames(FormattingHelper.getMapColorName(block.defaultMapColor())))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_INSTRUMENT.get()) {
                        list.add(Component.translatable("message.block_detective.instrument").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.FormatRegistryNames(String.valueOf(state.instrument())))
                                .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_IMPERMEABLE.get()) {
                        list.add(Component.translatable("message.block_detective.impermeable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.IMPERMEABLE)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_REPLACEABLE.get()) {
                        list.add(Component.translatable("message.block_detective.replaceable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.REPLACEABLE)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_ANIMAL_SPAWNABLE.get()) {
                        list.add(Component.translatable("message.block_detective.animal_spawnable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.ANIMALS_SPAWNABLE_ON)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_BEACON_BASE.get()) {
                        list.add(Component.translatable("message.block_detective.beacon_base").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.BEACON_BASE_BLOCKS)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_INFINIBURN.get()) {
                        list.add(Component.translatable("message.block_detective.infiniburn").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.INFINIBURN_END) || state.is(BlockTags.INFINIBURN_NETHER) || state.is(BlockTags.INFINIBURN_OVERWORLD)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_DAMPENS_VIBRATIONS.get()) {
                        list.add(Component.translatable("message.block_detective.dampens_vibrations").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.is(BlockTags.DAMPENS_VIBRATIONS)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                    if (Config.SHOW_IS_PATHFINDABLE.get()) {
                        list.add(Component.translatable("message.block_detective.pathfindable").append(separator).withStyle(ChatFormatting.YELLOW)
                                .append(Component.literal(FormattingHelper.ConvertBooleanToString(state.isPathfindable(PathComputationType.LAND)))
                                        .withStyle(ChatFormatting.GOLD)));
                    }
                }

                // Once the corresponding block is found, no need to continue iterating
                break;
            }
        }

        // If the item is not a block, add item-specific tooltips (only once)
        if (!isBlock && Config.ENABLE_ITEM_TOOLTIPS.get()) {
            if (!getKeyValue()) {
                if (Config.TOOLTIP_HINT_SIZE.get() != InformationTypes.HIDDEN) {
                    list.add(Component.translatable("message.block_detective.hold_" + getKeyString() + "_" + Config.TOOLTIP_HINT_SIZE.get() + ".desc")
                            .withStyle(ChatFormatting.GRAY));
                }

            } else {
                if (Config.SHOW_REGISTRY_NAME.get() && !Minecraft.getInstance().options.advancedItemTooltips) {
                    list.add(Component.literal(BuiltInRegistries.ITEM.getKey(item).toString())
                            .withStyle(ChatFormatting.GOLD));
                }
                if (Config.SHOW_MAX_SIZE.get()) {
                    list.add(Component.translatable("message.block_detective.max_size").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getMaxStackSize(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_MAX_DAMAGE.get()) {
                    list.add(Component.translatable("message.block_detective.max_damage").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getMaxDamage(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_DAMAGE.get()) {
                    list.add(Component.translatable("message.block_detective.damage").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDamage(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_STONE_MINING_SPEED.get() && item instanceof DiggerItem) {
                    list.add(Component.translatable("message.block_detective.stone_mining_speed").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.STONE.defaultBlockState())))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_DIRT_MINING_SPEED.get() && item instanceof DiggerItem) {
                    list.add(Component.translatable("message.block_detective.dirt_mining_speed").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.DIRT.defaultBlockState())))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_SHOW_WOOD_MINING_SPEED.get() && item instanceof DiggerItem) {
                    list.add(Component.translatable("message.block_detective.wood_mining_speed").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.getDestroySpeed(stack, Blocks.OAK_LOG.defaultBlockState())))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_ENCHANTABLE.get()) {
                    list.add(Component.translatable("message.block_detective.enchantable").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(Tags.Items.ENCHANTABLES)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_FOOD.get()) {
                    list.add(Component.translatable("message.block_detective.food").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(Tags.Items.FOODS)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_DYABLE.get()) {
                    list.add(Component.translatable("message.block_detective.dyable").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.DYEABLE)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_BEACON_PAYMENT.get()) {
                    list.add(Component.translatable("message.block_detective.beacon_payment").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.BEACON_PAYMENT_ITEMS)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_TRIM_MATERIAL.get()) {
                    list.add(Component.translatable("message.block_detective.trim_material").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.TRIM_MATERIALS)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_TRIMMABLE.get() && item instanceof ArmorItem) {
                    list.add(Component.translatable("message.block_detective.trimmable").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(stack.is(ItemTags.TRIMMABLE_ARMOR)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_GRINDSTONE_REPAIRABLE.get()) {
                    list.add(Component.translatable("message.block_detective.grindstone_repair").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(String.valueOf(item.canGrindstoneRepair(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_IS_PIGLIN_CURRENCY.get()) {
                    list.add(Component.translatable("message.block_detective.piglin_currency").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(item.isPiglinCurrency(stack)))
                                    .withStyle(ChatFormatting.GOLD)));
                }
                if (Config.SHOW_MAKES_PIGLINS_NEUTRAL.get()) {
                    list.add(Component.translatable("message.block_detective.piglins_neutral").append(separator).withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(FormattingHelper.ConvertBooleanToString(item.makesPiglinsNeutral(stack, Objects.requireNonNull(event.getEntity()))))
                                    .withStyle(ChatFormatting.GOLD)));
                }
            }
        }
    }



    private static boolean getKeyValue() {
        return Config.USE_CTRL_INSTEAD_OF_SHIFT.get() ? Screen.hasControlDown() : Screen.hasShiftDown();
    }


    private static String getKeyString() {
        return Config.USE_CTRL_INSTEAD_OF_SHIFT.get() ? "ctrl" : "shift";
    }


    /** Update Checker **/
    private static boolean hasShownUp = false;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Pre event) {
        if (Config.UPDATE_CHECKER != null && Config.UPDATE_CHECKER.get()) {

            if (!hasShownUp && Minecraft.getInstance().screen == null) {
                var player = Minecraft.getInstance().player;
                if (player == null) return;

                var modContainer = ModList.get().getModContainerById(References.MODID).orElse(null);

                if (modContainer != null) {
                    var versionCheckResult = VersionChecker.getResult(modContainer.getModInfo());

                    if (versionCheckResult.status() == VersionChecker.Status.OUTDATED || versionCheckResult.status() == VersionChecker.Status.BETA_OUTDATED) {
                        MutableComponent url = Component.translatable(ChatFormatting.GREEN + "Click here to update!")
                                .withStyle(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, References.URL)));

                        player.displayClientMessage(Component.literal(ChatFormatting.BLUE + "A newer version of " + ChatFormatting.YELLOW + References.NAME + ChatFormatting.BLUE + " is available!"), false);
                        player.displayClientMessage(url, false);

                        hasShownUp = true;

                    } else if (versionCheckResult.status() == VersionChecker.Status.FAILED) {
                        BlockDetective.LOGGER.error(References.NAME + "'s version checker failed!");
                        hasShownUp = true;
                    }
                }
            }
        }
    }


    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    /**
     * Distributes supporter rewards on first login.
     */
    @SubscribeEvent
    public static void SupporterRewards(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (Config.PATREON_REWARDS.get()) {
            // Check if the player already has rewards
            if (!player.getInventory().contains(new ItemStack(Items.PAPER))) {
                if (player instanceof ServerPlayer serverPlayer) { // Ensure the player is a ServerPlayer
                    // Check if the player is logging in for the first time
                    if (serverPlayer.getStats().getValue(Stats.CUSTOM, Stats.PLAY_TIME) < 5) {

                        // Perform supporter checks asynchronously
                        CompletableFuture.runAsync(() -> {
                            if (SupporterCheck(URI.create("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Supporter"), player)) {
                                giveSupporterReward(player, level);
                            }
                            if (SupporterCheck(URI.create("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Premium%20Supporter"), player)) {
                                givePremiumSupporterReward(player, level);
                            }
                            if (SupporterCheck(URI.create("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Elite"), player)) {
                                giveEliteReward(player);
                            }
                        });
                    }
                }
            }
        }
    }


    /**
     * Checks if the player is in the supporter list from the given URI.
     *
     * @param uri URI to a file containing supporter names
     * @param player The in-game player
     * @return true if the player is a supporter, otherwise false
     */
    private static boolean SupporterCheck(URI uri, Player player) {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse supporter list
            List<String> supporterList = List.of(response.body().split("\\R")); // Split lines
            return supporterList.contains(player.getName().getString());

        } catch (Exception e) {
            BlockDetective.LOGGER.error("Failed to fetch or process supporter list from URI: {}", uri, e);
            return false;
        }
    }


    private static void giveSupporterReward(Player player, Level level) {
        ItemStack certificate = new ItemStack(Items.PAPER);
        certificate.set(DataComponents.CUSTOM_NAME, Component.literal("Thank you for supporting me in my work!").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(" - XxRexRaptorxX").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GREEN)));

        ItemStack reward = new ItemStack(Items.PLAYER_HEAD);
        var profile = new GameProfile(player.getUUID(), player.getName().getString());
        reward.set(DataComponents.PROFILE, new ResolvableProfile(profile));

        level.playSound(null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
        player.getInventory().add(reward);
        player.getInventory().add(certificate);
    }

    private static void givePremiumSupporterReward(Player player, Level level) {
        ItemStack reward = new ItemStack(Items.DIAMOND_SWORD, 1);
        Registry<Enchantment> enchantmentsRegistry = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

        reward.enchant(enchantmentsRegistry.getOrThrow(Enchantments.MENDING), 1);
        reward.enchant(enchantmentsRegistry.getOrThrow(Enchantments.SHARPNESS), 3);
        reward.set(DataComponents.ENCHANTMENTS, reward.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY));
        player.getInventory().add(reward);
    }

    private static void giveEliteReward(Player player) {
        ItemStack star = new ItemStack(Items.NETHER_STAR);

        star.set(DataComponents.CUSTOM_NAME, Component.literal("Elite Star"));
        player.getInventory().add(star);
    }


    /**
     * Tests if a player is a supporter
     *
     * @param url url to a file that contains the supporter names
     * @param player ingame player
     * @return true/false
     */
    private static boolean SupporterCheck(URL url, Player player) {
        try {
            Scanner scanner = new Scanner(url.openStream());
            List<String> supporterList = scanner.tokens().toList();

            for (String name: supporterList) {
                //test if player is in supporter list
                if (player.getName().getString().equals(name)) {
                    return true;
                }
            }

            scanner.close();

        } catch (MalformedURLException e) {
            BlockDetective.LOGGER.error("Supporter list URL not found! >>{}", url);

        } catch (Exception e) {
            BlockDetective.LOGGER.error("An unexpected error occurred while checking supporter list", e);
        }

        return false;
    }


}
