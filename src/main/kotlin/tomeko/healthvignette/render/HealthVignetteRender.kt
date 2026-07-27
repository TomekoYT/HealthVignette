package tomeko.healthvignette.render

//? if = 1.8.9 {
/*import net.minecraft.client.Minecraft
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.Tessellator
import net.minecraft.client.renderer.vertex.DefaultVertexFormats
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
*///?} else {
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.renderer.RenderPipelines
import net.minecraft.resources.Identifier
//?}
import tomeko.healthvignette.config.HealthVignetteConfig
import tomeko.healthvignette.utils.Constants

object HealthVignetteRender {
    private val VIGNETTE_TEXTURE =
        //? if = 1.8.9 {
        /*ResourceLocation(
            *///?} else {
            Identifier.fromNamespaceAndPath(
            //?}
            Constants.MOD_ID,
            "textures/vignette.png"
        )

    fun register() {
        //? if = 1.8.9 {
        /*MinecraftForge.EVENT_BUS.register(this)
        *///?} else {
        HudElementRegistry.addLast(
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "health_vignette"),
        ) { guiGraphicsExtractor, _ ->
            render(guiGraphicsExtractor)
        }
        //?}
    }

    //? if = 1.8.9 {
    /*@SubscribeEvent
    *///?}
    fun render(
        //? if = 1.8.9 {
        /*event: RenderGameOverlayEvent.Post
        *///?} else {
        guiGraphicsExtractor: GuiGraphicsExtractor
        //?}
    ) {
        //? if = 1.8.9 {
        /*if (event.type != RenderGameOverlayEvent.ElementType.ALL) return
        *///?}

        val mc =
            //? if = 1.8.9 {
            /*Minecraft.getMinecraft()
        *///?} else {
        Minecraft.getInstance()
        //?}

        val player =
            //? if = 1.8.9 {
            /*mc.thePlayer ?: return
        *///?} else {
        mc.player ?: return
        //?}

        if (player.maxHealth <= 0 || 100 * player.health / player.maxHealth > HealthVignetteConfig.healthPercentage) return

        val width =
            //? if = 1.8.9 {
            /*ScaledResolution(mc).scaledWidth
        *///?} else {
        guiGraphicsExtractor.guiWidth()
        //?}

        val height =
            //? if = 1.8.9 {
            /*ScaledResolution(mc).scaledHeight
        *///?} else {
        guiGraphicsExtractor.guiHeight()
        //?}

        //? if = 1.8.9 {
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
            //? if = 1.8.9 {
            /*mc.textureManager.bindTexture(VIGNETTE_TEXTURE)

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
                VIGNETTE_TEXTURE,
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
            //? if = 1.8.9 {
            /*GlStateManager.disableTexture2D()

            val tessellator = Tessellator.getInstance()
            val renderer = tessellator.worldRenderer

            renderer.begin(
                7,
                DefaultVertexFormats.POSITION_COLOR
            )

            renderer.pos(0.0, height.toDouble(), 0.0)
                .color(HealthVignetteConfig.color.red, HealthVignetteConfig.color.green, HealthVignetteConfig.color.blue, HealthVignetteConfig.color.alpha)
                .endVertex()

            renderer.pos(width.toDouble(), height.toDouble(), 0.0)
                .color(HealthVignetteConfig.color.red, HealthVignetteConfig.color.green, HealthVignetteConfig.color.blue, HealthVignetteConfig.color.alpha)
                .endVertex()

            renderer.pos(width.toDouble(), 0.0, 0.0)
                .color(HealthVignetteConfig.color.red, HealthVignetteConfig.color.green, HealthVignetteConfig.color.blue, HealthVignetteConfig.color.alpha)
                .endVertex()

            renderer.pos(0.0, 0.0, 0.0)
                .color(HealthVignetteConfig.color.red, HealthVignetteConfig.color.green, HealthVignetteConfig.color.blue, HealthVignetteConfig.color.alpha)
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

        //? if = 1.8.9 {
        /*GlStateManager.disableBlend()
        GlStateManager.enableAlpha()
        GlStateManager.depthMask(true)
        GlStateManager.enableDepth()

        GlStateManager.popMatrix()
        *///?}
    }
}