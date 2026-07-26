package tomeko.healthvignette.commands

//? if = 1.8.9 {
/*import cc.polyfrost.oneconfig.utils.commands.CommandManager
import cc.polyfrost.oneconfig.utils.commands.annotations.Command
import cc.polyfrost.oneconfig.utils.commands.annotations.Main
*///?} else {
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.commands.CommandBuildContext
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import org.polyfrost.oneconfig.utils.v1.dsl.openUI
import net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal
import net.minecraft.client.Minecraft
//?}
import tomeko.healthvignette.config.HealthVignetteConfig
import tomeko.healthvignette.utils.Constants

//? if = 1.8.9 {
/*@Command(value = Constants.MOD_ID)
 *///?}
object HealthVignetteCommand {
    //? if >= 26.1 {
    private var shouldOpenConfig: Boolean = false
    //?}

    fun register() {
        //? if = 1.8.9 {
        /*CommandManager.INSTANCE.registerCommand(this)
         *///?} else {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher: CommandDispatcher<FabricClientCommandSource>, _: CommandBuildContext ->
            dispatcher.register(
                literal(Constants.MOD_ID)
                    .executes { _: CommandContext<FabricClientCommandSource> ->
                        shouldOpenConfig = true
                        return@executes 1
                    }
            )
        }

        ClientTickEvents.END_CLIENT_TICK.register { _: Minecraft ->
            if (!shouldOpenConfig) return@register

            HealthVignetteConfig.openUI()

            shouldOpenConfig = false
        }
        //?}
    }

    //? if = 1.8.9 {
    /*@Main
    fun handle() {
        HealthVignetteConfig.openGui()
    }
    *///?}
}