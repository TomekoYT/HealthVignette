package tomeko.healthvignette.hud;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
//? if >= 26.1 {
//import net.minecraft.client.gui.GuiGraphicsExtractor;
//?} else {
import net.minecraft.client.gui.GuiGraphics;
//?}
//? if >= 1.21.11 {
//import net.minecraft.resources.Identifier;
//?} else {
import net.minecraft.resources.ResourceLocation;
//?}
import tomeko.healthvignette.config.HealthVignetteConfig;
import tomeko.healthvignette.utils.Constants;

public class HealthVignetteRender {
    public static void register() {
        //? if >= 1.21.11 {
        //HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.fromNamespaceAndPath(Constants.MOD_ID, "before_chat"), HealthVignetteRender::render);
        //?} else {
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "before_chat"), HealthVignetteRender::render);
        //?}
    }

    //? if >= 26.1 {
    //private static void render(GuiGraphicsExtractor context, DeltaTracker tickDelta) {
    //?} else {
    private static void render(GuiGraphics context, DeltaTracker tickDelta) {
        //?}
        Minecraft client = Minecraft.getInstance();
        if (!HealthVignetteConfig.healthVignetteEnabled
                || client.player == null
                || client.player.getMaxHealth() <= 0
                || client.player.getHealth() / client.player.getMaxHealth() > HealthVignetteConfig.healthVignetteHealthPercentage / 100
        ) return;

        int alpha = (int) ((HealthVignetteConfig.healthVignetteOpacityPercentage / 100) * 255.0f);
        context.fill(0, 0, client.getWindow().getGuiScaledWidth(), client.getWindow().getGuiScaledHeight(), ((alpha << 24) | 0xFF0000));
    }
}
