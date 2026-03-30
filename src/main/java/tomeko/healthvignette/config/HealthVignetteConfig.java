package tomeko.healthvignette.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import tomeko.healthvignette.utils.Constants;

public class HealthVignetteConfig {
    public static final ConfigClassHandler<HealthVignetteConfig> CONFIG = ConfigClassHandler.createBuilder(HealthVignetteConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(YACLPlatform.getConfigDir().resolve(Constants.MOD_ID + ".json"))
                    .build())
            .build();

    @SerialEntry
    public static boolean healthVignetteEnabled = true;
    @SerialEntry
    public static float healthVignetteOpacityPercentage = 25F;
    @SerialEntry
    public static float healthVignetteHealthPercentage = 20F;

    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Component.literal(Constants.MOD_NAME))

                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Health Vignette Config"))

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enabled"))
                                .binding(defaults.healthVignetteEnabled, () -> config.healthVignetteEnabled, newVal -> config.healthVignetteEnabled = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.<Float>createBuilder()
                                .name(Component.literal("Set Opacity Percentage"))
                                .description(OptionDescription.of(Component.literal("Set Health Vignette's opacity")))
                                .binding(defaults.healthVignetteOpacityPercentage, () -> config.healthVignetteOpacityPercentage, newVal -> config.healthVignetteOpacityPercentage = newVal)
                                .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                        .formatValue(value -> Component.literal(String.format("%,.0f", value) + "%"))
                                        .range(0F, 100F)
                                        .step(1F))
                                .build())
                        .option(Option.<Float>createBuilder()
                                .name(Component.literal("Set Health Percentage"))
                                .description(OptionDescription.of(Component.literal("Set % of health for which Health Vignette will be shown")))
                                .binding(defaults.healthVignetteHealthPercentage, () -> config.healthVignetteHealthPercentage, newVal -> config.healthVignetteHealthPercentage = newVal)
                                .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                        .formatValue(value -> Component.literal(String.format("%,.0f", value) + "%"))
                                        .range(0F, 100F)
                                        .step(1F))
                                .build())
                        .build())

        )).generateScreen(parent);
    }

    public static void register() {
        HealthVignetteConfig.CONFIG.load();
    }
}
