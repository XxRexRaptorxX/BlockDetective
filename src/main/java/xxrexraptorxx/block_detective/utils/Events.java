package xxrexraptorxx.block_detective.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.VersionChecker;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import xxrexraptorxx.block_detective.main.BlockDetective;
import xxrexraptorxx.block_detective.main.References;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Events {


    /**
     * Adds tooltips to the items.
     **/
    @SubscribeEvent
    public static void addingToolTips(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        List<Component> list = event.getToolTip();

        if (Config.ENABLE_ITEM_TOOLTIPS.get()) {
            for (Block block : BuiltInRegistries.BLOCK) {
                if (BuiltInRegistries.ITEM.getKey(item) == BuiltInRegistries.BLOCK.getKey(block)) {

                    if (!Screen.hasShiftDown()) {
                        if (Config.SHOW_LONG_SHIFT_TEXT.get()) {
                            list.add(Component.translatable("message.block_detective.hold_shift_extended.desc").withStyle(ChatFormatting.GRAY));
                        } else {
                            list.add(Component.translatable("message.block_detective.hold_shift.desc").withStyle(ChatFormatting.GRAY));
                        }

                    } else {
                        if (Config.SHOW_REGISTRY_NAME.get()) list.add(Component.literal(BuiltInRegistries.ITEM.getKey(item).toString()).withStyle(ChatFormatting.GOLD));
                        if (Config.SHOW_DESTROY_TIME.get()) list.add(Component.translatable("message.block_detective.destroy_time").append(": " + (block.defaultDestroyTime())).withStyle(ChatFormatting.YELLOW));
                        if (Config.SHOW_JUMP_FACTOR.get()) list.add(Component.translatable("message.block_detective.jump_factor").append(": " + (block.getJumpFactor())).withStyle(ChatFormatting.YELLOW));
                        if (Config.SHOW_SPEED_FACTOR.get()) list.add(Component.translatable("message.block_detective.speed_factor").append(": " + (block.getSpeedFactor())).withStyle(ChatFormatting.YELLOW));
                        if (Config.SHOW_LIGHT_LEVEL.get()) list.add(Component.translatable("message.block_detective.light_level").append(": " + (block.defaultBlockState().getLightEmission())).withStyle(ChatFormatting.YELLOW));
                        if (Config.SHOW_FRICTION.get()) list.add(Component.translatable("message.block_detective.friction").append(": " + (block.getFriction())).withStyle(ChatFormatting.YELLOW));
                        //if (Config.SHOW_IF_FLAMMABLE.get()) list.add(Component.translatable("message.block_detective.flammable").append(": ").append(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().getProperties().isFlammable())).withStyle(ChatFormatting.YELLOW));
                        //if (Config.SHOW_IF_SOLID.get()) list.add(Component.translatable("message.block_detective.solid").append(": ").append(FormattingHelper.ConvertBooleanToString(block.defaultBlockState().getMaterial().isSolid())).withStyle(ChatFormatting.YELLOW));
                    }
                }
            }
        }
    }



    /** Update-Checker **/
    private static boolean hasShownUp = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (Config.UPDATE_CHECKER.get()) {
            if (!hasShownUp && Minecraft.getInstance().screen == null) {
                if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.OUTDATED ||
                        VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.BETA_OUTDATED ) {

                    MutableComponent url = Component.literal(ChatFormatting.GREEN + "Click here to update!");
                    url.withStyle(url.getStyle().withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, References.URL)));

                    Minecraft.getInstance().player.displayClientMessage(Component.literal(ChatFormatting.BLUE + "A newer version of " + ChatFormatting.YELLOW + References.NAME + ChatFormatting.BLUE + " is available!"), false);
                    Minecraft.getInstance().player.displayClientMessage(url, false);

                    hasShownUp = true;

                } else if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.FAILED) {
                    BlockDetective.LOGGER.error(References.NAME + "'s version checker failed!");
                    hasShownUp = true;

                }
            }
        }
    }


    /**
     * Distributes the supporter rewards on first join.
     */
    @SubscribeEvent
    public static void SupporterRewards(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (Config.PATREON_REWARDS.get()) {

            try {
                URL SUPPORTER_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Supporter");
                URL PREMIUM_SUPPORTER_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Premium%20Supporter");
                URL ELITE_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Elite");

                //test if a player already has rewards
                if (!player.getInventory().contains(new ItemStack(Items.PAPER))) {

                    ServerPlayer serverPlayer = (ServerPlayer) player;
                    //test if player joins the first time
                    if (serverPlayer.getStats().getValue(Stats.CUSTOM, Stats.PLAY_TIME) < 5) {

                        //test if player is supporter
                        if (SupporterCheck(SUPPORTER_URL, player)) {

                            ItemStack certificate = new ItemStack(Items.PAPER).setHoverName((Component.literal("Thank you for supporting me in my work!").withStyle(ChatFormatting.GOLD).append(Component.literal(" - XxRexRaptorxX").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GREEN))));

                            CompoundTag ownerNBT = new CompoundTag();
                            ItemStack reward = new ItemStack(Items.PLAYER_HEAD);
                            ownerNBT.putString("SkullOwner", player.getName().getString());
                            reward.setTag(ownerNBT);

                            level.playSound((Player) null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                            player.addItem(reward);
                            player.addItem(certificate);
                        }

                        //test if player is premium supporter
                        if (SupporterCheck(PREMIUM_SUPPORTER_URL, player)) {
                            ItemStack reward = new ItemStack(Items.DIAMOND_SWORD, 1).setHoverName(Component.literal("Rex's Night Sword").withStyle(ChatFormatting.DARK_GRAY));
                            reward.enchant(Enchantments.MENDING, 1);
                            reward.enchant(Enchantments.SHARPNESS, 3);
                            player.addItem(reward);
                        }

                        //test if player is elite
                        if (SupporterCheck(ELITE_URL, player)) {
                            player.addItem(new ItemStack(Items.NETHER_STAR).setHoverName(Component.literal("Elite Star")));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
            BlockDetective.LOGGER.error("Supporter list URL not found! >>" + url);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
