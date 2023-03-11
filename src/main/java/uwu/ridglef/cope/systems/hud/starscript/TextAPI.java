package uwu.ridglef.cope.systems.hud.starscript;

import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.elements.TextHud;
import uwu.ridglef.cope.RidglefAddon;

public class TextAPI {
    public static final HudElementInfo<TextHud> INFO = new HudElementInfo<>(RidglefAddon.HUD_GROUP, "ridglef-presets", "", TextAPI::create);

    public static TextHud create() {
        return new TextHud(INFO);
    }

    public static HudElementInfo<TextHud>.Preset create(String name, String presettext) {
        return INFO.addPreset(name, textHud -> {
            textHud.text.set(presettext);
            textHud.updateDelay.set(1);
        });
    }
}
