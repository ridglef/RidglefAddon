package uwu.ridglef.cope.systems;

import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.tutorial.TutorialStep;
import uwu.ridglef.cope.systems.hud.starscript.Presets;
import uwu.ridglef.cope.systems.hud.starscript.TextAPI;
import uwu.ridglef.cope.systems.modules.ChatMods;
import uwu.ridglef.cope.systems.modules.ExternalToggle;
import uwu.ridglef.cope.systems.modules.HASHMAP;
import uwu.ridglef.cope.systems.utils.RidglefStarScript;

public class Manager {
    public static void lm(){
        RidglefStarScript.init();
        MinecraftClient.getInstance().getTutorialManager().setStep(TutorialStep.NONE);
        Modules m = new Modules().get();
        Commands c = new Commands().get();

        // Modules
        m.add(new ChatMods());
        m.add(new ExternalToggle());
        m.add(new HASHMAP());
        // HUD
        Hud.get().register(TextAPI.INFO);
        Presets.add();
    }
}
