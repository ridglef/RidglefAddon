package uwu.ridglef.cope.systems;

import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.tutorial.TutorialStep;
import uwu.ridglef.cope.systems.commands.CommandExample;
import uwu.ridglef.cope.systems.hud.HudExample;
import uwu.ridglef.cope.systems.modules.ChatMods;

public class Manager {
    public static void lm(){
        MinecraftClient.getInstance().getTutorialManager().setStep(TutorialStep.NONE);
        Modules m = new Modules().get();
        Commands c = new Commands().get();

        // Modules
        m.add(new ChatMods());

        // Commands
        c.add(new CommandExample());

        // HUD
        Hud.get().register(HudExample.INFO);
    }
}
