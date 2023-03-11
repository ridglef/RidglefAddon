package uwu.ridglef.cope.systems.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.ModuleListSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.movement.AutoWalk;
import meteordevelopment.orbit.EventHandler;
import uwu.ridglef.cope.RidglefAddon;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class ExternalToggle extends Module {
    public ExternalToggle() {
        super(RidglefAddon.CATEGORY, "External-Toggle", "Toggle modules outside of the client");
    }
    private SettingGroup sgGeneral = settings.getDefaultGroup();
    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();

    public final Setting<List<Module>> selectedModules = sgGeneral.add(new ModuleListSetting.Builder()
        .name("modules")
        .defaultValue(new ArrayList<>() {{
            add(Modules.get().get(AutoWalk.class));}})
        .build()
    );

    public static void run(){
            panel.removeAll();
            frame.add(panel);
            Modules.get().get(ExternalToggle.class).selectedModules.get().forEach(module -> {
                JButton e = new JButton(("Toggle " + module.title));
                panel.add(e);
                e.addActionListener(actionEvent -> {
                    module.toggle();
                });
            });
             panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            frame.setVisible(true);
            frame.setResizable(true);
    }
    @EventHandler
    private void onTick(TickEvent.Post event) {
        run();
    }

    @Override
    public void onDeactivate(){
        if (frame.isVisible()){frame.setVisible(false);}
    }
    @Override
    public void onActivate(){
        frame.setSize(300,300);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (Modules.get().get(ExternalToggle.class).isActive()){
                    Modules.get().get(ExternalToggle.class).toggle();
                }
            }
        });
    }
}
