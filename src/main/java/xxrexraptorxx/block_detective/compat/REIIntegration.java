package xxrexraptorxx.block_detective.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.client.BuiltinClientPlugin;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.block_detective.utils.FormattingHelper;

@REIPluginClient
public class REIIntegration implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {

        if (Config.ENABLE_JEI_ITEM_PAGES.get()) {
            BuiltinClientPlugin instance = BuiltinClientPlugin.getInstance();

            for (Block block : BuiltInRegistries.BLOCK) {
                instance.registerInformation(EntryStacks.of(block), Component.empty(), list -> {
                        list.add(FormattingHelper.getPageDescription(block));
                        return list;
                });
            }
        }
    }

}

