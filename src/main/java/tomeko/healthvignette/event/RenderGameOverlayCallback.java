package tomeko.healthvignette.event;

//? if 1.8.9 {
/*import java.util.ArrayList;
import java.util.List;

public final class RenderGameOverlayCallback {
    private static final List<Listener> LISTENERS = new ArrayList<>();

    private RenderGameOverlayCallback() {}

    public static void register(Listener listener) {
        LISTENERS.add(listener);
    }

    public static void invoke(RenderGameOverlayEvent event) {
        for (Listener listener : LISTENERS) {
            listener.onRender(event);
        }
    }

    @FunctionalInterface
    public interface Listener {
        void onRender(RenderGameOverlayEvent event);
    }
}
*///?}