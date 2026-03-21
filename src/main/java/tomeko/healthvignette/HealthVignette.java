package tomeko.healthvignette;

import net.fabricmc.api.ClientModInitializer;
import tomeko.healthvignette.config.*;
import tomeko.healthvignette.hud.*;

public class HealthVignette implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HealthVignetteConfig.register();

		HealthVignetteRender.register();
	}
}