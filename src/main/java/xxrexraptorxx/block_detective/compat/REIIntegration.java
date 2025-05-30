package xxrexraptorxx.block_detective.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.client.BuiltinClientPlugin;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.block_detective.utils.NameHelper;

@REIPluginClient
public class REIIntegration implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        BuiltinClientPlugin instance = BuiltinClientPlugin.getInstance();

        if (Config.isJeiBlockPagesEnabled()) {
            for (Block block : BuiltInRegistries.BLOCK) {
                instance.registerInformation(EntryStacks.of(block), Component.empty(), list -> {
                        list.add(NameHelper.getPageDescription(block));
                        return list;
                });
            }
        }
        if (Config.isJeiItemPagesEnabled()) {
            for (Item item : BuiltInRegistries.ITEM) {
                instance.registerInformation(EntryStacks.of(item), Component.empty(), list -> {
                    list.add(NameHelper.getPageDescription(item));
                    return list;
                });
            }
        }
    }

}

