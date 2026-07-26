package tomeko.healthvignette.config

//? if = 1.8.9 {
/*import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.Color
import cc.polyfrost.oneconfig.config.annotations.Dropdown
import cc.polyfrost.oneconfig.config.annotations.Slider
import cc.polyfrost.oneconfig.config.core.OneColor as PolyColor
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
*///?} else {
import org.polyfrost.compose.render.PolyColor
import org.polyfrost.oneconfig.api.config.v1.Config
import org.polyfrost.oneconfig.api.config.v1.annotations.Color
import org.polyfrost.oneconfig.api.config.v1.annotations.Dropdown
import org.polyfrost.oneconfig.api.config.v1.annotations.Slider
//?}
import tomeko.healthvignette.utils.Constants

object HealthVignetteConfig : Config(
    //? if = 1.8.9 {
    /*Mod(
        Constants.MOD_NAME,
        ModType.HUD,
        "/assets/${Constants.MOD_ID}/icon.png"
    ),
    "${Constants.MOD_ID}.json"
    *///?} else {
    "${Constants.MOD_ID}.json",
    "/assets/${Constants.MOD_ID}/icon.png",
    Constants.MOD_NAME,
    Category.VISUALS
    //?}
) {
    fun register() {
        //? if = 1.8.9 {
        /*initialize()
        *///?} else {
        preload()
        //?}
    }

    @Dropdown(
        //? if = 1.8.9 {
        /*name =
            *///?} else {
        title =
            //?}
            "Mode",
        options = [
            "Border",
            "Full"
        ]
    )
    var mode = 0

    @Slider(
        //? if = 1.8.9 {
        /*name =
            *///?} else {
        title =
            //?}
            "Health Percentage",
        min = 0f,
        max = 100f,
        step =
            //? if = 1.8.9 {
            /*1
            *///?} else {
            1f
        //?}
    )
    var healthPercentage = 20

    @Color(
        //? if = 1.8.9 {
        /*name =
            *///?} else {
        title =
            //?}
            "Color"
    )
    var color = PolyColor(0x66FF0000.toInt())
}