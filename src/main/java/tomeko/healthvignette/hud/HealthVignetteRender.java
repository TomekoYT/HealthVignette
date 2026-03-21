package tomeko.healthvignette.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import tomeko.healthvignette.config.HealthVignetteConfig;

public class HealthVignetteRender {
    public static void register() {
        HudRenderCallback.EVENT.register(HealthVignetteRender::render);
    }

    private static void render(DrawContext context, RenderTickCounter tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!HealthVignetteConfig.healthVignetteEnabled
                || client.player == null
                || client.player.getMaxHealth() <= 0
                || client.player.getHealth() / client.player.getMaxHealth() > HealthVignetteConfig.healthVignetteHealthPercentage / 100
        ) return;

        int alpha = (int) ((HealthVignetteConfig.healthVignetteOpacityPercentage / 100) * 255.0f);
        context.fill(0, 0, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight(), ((alpha << 24) | 0xFF0000));
    }
}
