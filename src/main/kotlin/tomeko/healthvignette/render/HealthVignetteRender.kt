package tomeko.healthvignette.render

//? if 1.8.9 {
/*import net.minecraft.client.Minecraft
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.Tessellator
import net.minecraft.client.renderer.vertex.DefaultVertexFormats
import net.minecraft.util.ResourceLocation
*///?} else {
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.renderer.RenderPipelines
import net.minecraft.resources.Identifier
//?}
import tomeko.healthvignette.config.HealthVignetteConfig
//? if 1.8.9 {
/*import tomeko.healthvignette.event.RenderGameOverlayCallback
import tomeko.healthvignette.event.RenderGameOverlayEvent
*///?}
import tomeko.healthvignette.utils.Constants

object HealthVignetteRender {
    private var resourceLoaded = false

    fun register() {
        //? if 1.8.9 {
        //RenderGameOverlayCallback.register(::render)
        //?} else {
        HudElementRegistry.addLast(
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "health_vignette"),
        ) { guiGraphicsExtractor, _ ->
            render(guiGraphicsExtractor)
        }
        //?}
    }

    private fun render(
        //? if 1.8.9 {
        //event: RenderGameOverlayEvent
        //?} else {
        guiGraphicsExtractor: GuiGraphicsExtractor
        //?}
    ) {
        //? if 1.8.9 {
        //if (event.type != RenderGameOverlayEvent.ElementType.ALL) return
        //?}

        val mc =
            //? if 1.8.9 {
            //Minecraft.getMinecraft()
        //?} else {
        Minecraft.getInstance()
        //?}

        //? if 1.8.9 {
        //val resolution = ScaledResolution(mc)
        //?}

        val width =
        //? if 1.8.9 {
        //resolution.scaledWidth
            //?} else {
            guiGraphicsExtractor.guiWidth()
        //?}

        val height =
        //? if 1.8.9 {
        //resolution.scaledHeight
            //?} else {
            guiGraphicsExtractor.guiHeight()
        //?}

        if (!resourceLoaded) {
            //? if 1.8.9 {
            //mc.textureManager.bindTexture(ResourceLocation(Constants.MOD_ID, "textures/vignette.png"))
            //?} else {
            guiGraphicsExtractor.blit(
                RenderPipelines.GUI_TEXTURED,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/vignette.png"),
                0,
                0,
                0f,
                0f,
                width,
                height,
                width,
                height,
                HealthVignetteConfig.color.argb
            )
            //?}
            resourceLoaded = true
        }

        val player =
            //? if 1.8.9 {
            //mc.thePlayer ?: return
        //?} else {
        mc.player ?: return
        //?}

        if (player.maxHealth <= 0 || 100 * player.health / player.maxHealth > HealthVignetteConfig.healthPercentage) return

        //? if 1.8.9 {
        /*GlStateManager.pushMatrix()

        GlStateManager.disableDepth()
        GlStateManager.depthMask(false)
        GlStateManager.disableLighting()
        GlStateManager.disableAlpha()
        GlStateManager.enableBlend()
        GlStateManager.tryBlendFuncSeparate(
            770,
            771,
            1,
            0
        )
        *///?}

        if (HealthVignetteConfig.mode == 0) {
            //? if 1.8.9 {
            /*mc.textureManager.bindTexture(ResourceLocation(Constants.MOD_ID, "textures/vignette.png"))

            GlStateManager.color(
                1f,
                1f,
                1f,
                1f
            )

            val tessellator = Tessellator.getInstance()
            val renderer = tessellator.worldRenderer

            renderer.begin(
                7,
                DefaultVertexFormats.POSITION_TEX_COLOR
            )

            renderer.pos(0.0, height.toDouble(), 0.0)
                .tex(0.0, 1.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            renderer.pos(width.toDouble(), height.toDouble(), 0.0)
                .tex(1.0, 1.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            renderer.pos(width.toDouble(), 0.0, 0.0)
                .tex(1.0, 0.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            renderer.pos(0.0, 0.0, 0.0)
                .tex(0.0, 0.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            tessellator.draw()
            *///?} else {
            guiGraphicsExtractor.blit(
                RenderPipelines.GUI_TEXTURED,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "textures/vignette.png"),
                0,
                0,
                0f,
                0f,
                width,
                height,
                width,
                height,
                HealthVignetteConfig.color.argb
            )
            //?}
        } else {
            //? if 1.8.9 {
            /*GlStateManager.disableTexture2D()

            val tessellator = Tessellator.getInstance()
            val renderer = tessellator.worldRenderer

            renderer.begin(
                7,
                DefaultVertexFormats.POSITION_COLOR
            )

            renderer.pos(0.0, height.toDouble(), 0.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            renderer.pos(width.toDouble(), height.toDouble(), 0.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            renderer.pos(width.toDouble(), 0.0, 0.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            renderer.pos(0.0, 0.0, 0.0)
                .color(
                    HealthVignetteConfig.color.red,
                    HealthVignetteConfig.color.green,
                    HealthVignetteConfig.color.blue,
                    HealthVignetteConfig.color.alpha
                )
                .endVertex()

            tessellator.draw()
            GlStateManager.enableTexture2D()
            *///?} else {
            guiGraphicsExtractor.fill(
                0,
                0,
                width,
                height,
                HealthVignetteConfig.color.argb
            )
            //?}
        }

        //? if 1.8.9 {
        /*GlStateManager.disableBlend()
        GlStateManager.enableAlpha()
        GlStateManager.depthMask(true)
        GlStateManager.enableDepth()

        GlStateManager.popMatrix()
        *///?}
    }
}