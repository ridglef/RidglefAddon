package uwu.ridglef.cope;

import uwu.ridglef.cope.systems.Manager;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class RidglefAddon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Ridglef");
    public static final HudGroup HUD_GROUP = new HudGroup("Ridglef");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Ridglef Addon. Cope.");
        Manager.lm();
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "uwu.ridglef.cope";
    }
}
