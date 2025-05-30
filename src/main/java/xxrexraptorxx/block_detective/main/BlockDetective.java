package xxrexraptorxx.block_detective.main;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.block_detective.utils.Config;
import xxrexraptorxx.magmacore.config.ConfigHelper;
import xxrexraptorxx.magmacore.main.ModRegistry;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/block-detective">...</a>
 **/
@Mod(References.MODID)
public class BlockDetective {

    public static final Logger LOGGER = LogManager.getLogger();

    public BlockDetective(ModContainer container) {
        ConfigHelper.registerConfigs(container, References.MODID, false, null, Config.CLIENT_CONFIG);
        ModRegistry.register(References.MODID, References.NAME, References.URL);
    }


    @Mod(value = References.MODID, dist = Dist.CLIENT)
    public static class BlockDetectiveClient {

        public BlockDetectiveClient(ModContainer container) {
            ConfigHelper.registerIngameConfig(container);
        }
    }
}