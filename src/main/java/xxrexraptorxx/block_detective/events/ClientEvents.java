//package xxrexraptorxx.block_detective.events;
//
//import com.mojang.blaze3d.platform.InputConstants;
//import net.minecraft.client.KeyMapping;
//import net.minecraft.client.Minecraft;
//import net.neoforged.api.distmarker.Dist;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
//import net.neoforged.neoforge.client.settings.KeyConflictContext;
//import net.neoforged.neoforge.common.util.Lazy;
//import org.lwjgl.glfw.GLFW;
//import xxrexraptorxx.block_detective.main.References;
//
//@EventBusSubscriber(modid = References.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
//public class ClientEvents {
//
//      TODO!
//    public static final Lazy<KeyMapping> BLOCK_DETECTIVE_MAPPING = Lazy.of(() -> new KeyMapping("key.block_detective.additional_information",
//            KeyConflictContext.GUI, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_SHIFT, KeyMapping.CATEGORY_INVENTORY));
//
//
//    @SubscribeEvent
//    public static void registerBindings(RegisterKeyMappingsEvent event) {
//        event.register(BLOCK_DETECTIVE_MAPPING.get());
//    }
//
//}
