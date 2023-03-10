package uwu.ridglef.cope.systems;

import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.modules.Modules;
import uwu.ridglef.cope.systems.commands.CommandExample;
import uwu.ridglef.cope.systems.hud.HudExample;
import uwu.ridglef.cope.systems.modules.ModuleExample;

public class Manager {
    public static void lm(){
        Modules m = new Modules().get();
        Commands c = new Commands().get();

        // Modules
        m.add(new ModuleExample());

        // Commands
        c.add(new CommandExample());

        // HUD
        Hud.get().register(HudExample.INFO);
    }
}
