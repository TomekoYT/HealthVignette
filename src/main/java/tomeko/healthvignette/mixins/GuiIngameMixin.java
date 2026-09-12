package tomeko.healthvignette.mixins;

//? if 1.8.9 {
/*import net.minecraft.client.gui.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tomeko.healthvignette.event.RenderGameOverlayCallback;
import tomeko.healthvignette.event.RenderGameOverlayEvent;

@Mixin(GuiIngame.class)
public class GuiIngameMixin {
    @Inject(method = "renderGameOverlay", at = @At("TAIL"))
    private void onRenderGameOverlay(float partialTicks, CallbackInfo ci) {
        RenderGameOverlayCallback.invoke(new RenderGameOverlayEvent(partialTicks, RenderGameOverlayEvent.ElementType.ALL));
    }
}
*///?}