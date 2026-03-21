package tomeko.healthvignette;

import net.fabricmc.api.ClientModInitializer;
import tomeko.healthvignette.config.HealthVignetteConfig;

public class HealthVignette implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HealthVignetteConfig.register();
	}
}