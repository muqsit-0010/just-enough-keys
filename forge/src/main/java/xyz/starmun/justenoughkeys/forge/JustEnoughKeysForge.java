package xyz.starmun.justenoughkeys.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import xyz.starmun.justenoughkeys.common.JustEnoughKeys;
import net.minecraftforge.fml.common.Mod;
import xyz.starmun.justenoughkeys.common.client.JEKControls;
import xyz.starmun.justenoughkeys.common.client.Config;

@Mod(JustEnoughKeys.MOD_ID)
@Mod.EventBusSubscriber(modid = JustEnoughKeys.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JustEnoughKeysForge {
    public JustEnoughKeysForge() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "", (a, b) -> true));
        JustEnoughKeys.init();
    }

    @SubscribeEvent
    public static void registerClientEvent(RegisterKeyMappingsEvent event) {
        if (Config.isCustomDropKeyFeatureEnabled()) {
            event.register(JEKControls.dropStack);
        }
    }
}
