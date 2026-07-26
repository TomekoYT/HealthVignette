package tomeko.healthvignette.render

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.renderer.RenderPipelines
import net.minecraft.resources.Identifier
import tomeko.healthvignette.config.HealthVignetteConfig
import tomeko.healthvignette.utils.Constants

object HealthVignetteRender {
    fun register() {
        HudElementRegistry.addLast(
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "health_vignette"),
        ) { guiGraphicsExtractor, _ ->
            render(guiGraphicsExtractor)
        }
    }

    fun render(guiGraphicsExtractor: GuiGraphicsExtractor) {
        val mc = Minecraft.getInstance()
        if (mc.player == null || mc.player!!.maxHealth <= 0 || 100 * mc.player!!.health / mc.player!!.maxHealth > HealthVignetteConfig.healthPercentage) return

        if (HealthVignetteConfig.mode == 0) {
            guiGraphicsExtractor.blit(
                RenderPipelines.GUI_TEXTURED,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/vignette.png"),
                0,
                0,
                0f,
                0f,
                guiGraphicsExtractor.guiWidth(),
                guiGraphicsExtractor.guiHeight(),
                guiGraphicsExtractor.guiWidth(),
                guiGraphicsExtractor.guiHeight(),
                HealthVignetteConfig.color.argb
            )
        } else {
            guiGraphicsExtractor.fill(
                0,
                0,
                guiGraphicsExtractor.guiWidth(),
                guiGraphicsExtractor.guiHeight(),
                HealthVignetteConfig.color.argb
            )
        }
    }
}