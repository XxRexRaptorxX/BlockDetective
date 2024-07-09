package xxrexraptorxx.block_detective.main;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.block_detective.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/block-detective
 **/
@Mod(References.MODID)
public class BlockDetective {

    public static final Logger LOGGER = LogManager.getLogger();

    public BlockDetective(ModContainer container) {
        Config.init(container);
    }
}