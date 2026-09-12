package tomeko.healthvignette.config

//? if forge {
/*import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.*
import cc.polyfrost.oneconfig.config.data.InfoType
import cc.polyfrost.oneconfig.config.core.OneColor as PolyColor
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
*///?} else {
import org.polyfrost.compose.render.PolyColor
import org.polyfrost.oneconfig.api.config.v1.Config
import org.polyfrost.oneconfig.api.config.v1.annotations.*
//?}
import tomeko.healthvignette.utils.Constants

object HealthVignetteConfig : Config(
    //? if forge {
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
        //? if forge {
        //initialize()
        //?} else {
        preload()
        //?}
    }


    //? if forge {
    //@Exclude
    //?}
    private const val CATEGORY_GENERAL = "Debug"

    @Dropdown(
        //? if forge {
        //name =
            //?} else {
        title =
            //?}
            "Mode",
        description = "Change Health Vignette mode\nBorder: only edges of the screen\nFull: whole screen",
        options = [
            "Border",
            "Full"
        ],
        category = CATEGORY_GENERAL,
    )
    var mode = 0

    @Slider(
        //? if forge {
        //name =
            //?} else {
        title =
            //?}
            "Health Percentage",
        description = "Set the health percentage at which the Health Vignette appears",
        min = 0f,
        max = 100f,
        step =
            //? if forge {
            //1,
            //?} else {
            1f,
        //?}
        category = CATEGORY_GENERAL,
    )
    var healthPercentage = 20

    @Color(
        //? if forge {
        //name =
            //?} else {
        title =
            //?}
            "Color",
        description = "Choose the color of the Health Vignette",
        category = CATEGORY_GENERAL,
    )
    var color = PolyColor(0x66FF0000.toInt())


    //? if forge {
    //@Exclude
    //?}
    private const val CATEGORY_DEBUG = "Debug"

    @Info(
        //? if forge {
        //text =
        //?} else {
        title =
            //?}
            "Probably should stay disabled",
        //? if forge {
        //type = InfoType.WARNING,
        //?}
        category = CATEGORY_DEBUG,
    )
    var debugModeInfo: Nothing? = null

    @Switch(
        //? if forge {
        //name =
        //?} else {
        title =
            //?}
            "Debug Mode",
        category = CATEGORY_DEBUG,
    )
    var debugModeEnabled = false
}