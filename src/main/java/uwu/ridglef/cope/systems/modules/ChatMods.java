package uwu.ridglef.cope.systems.modules;

import meteordevelopment.meteorclient.events.game.SendMessageEvent;
import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.widgets.WLabel;
import meteordevelopment.meteorclient.gui.widgets.WWidget;
import meteordevelopment.meteorclient.gui.widgets.containers.WTable;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.orbit.EventHandler;
import uwu.ridglef.cope.RidglefAddon;
import meteordevelopment.meteorclient.systems.modules.Module;
import uwu.ridglef.cope.systems.utils.ChatModificationUtils;
import java.util.ArrayList;
import java.util.List;

public class ChatMods extends Module {
    public ChatMods() {
        super(RidglefAddon.CATEGORY, "Chat-Mods", "modifies your chat");
    }
    private SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Boolean> emojis = sgGeneral.add(new BoolSetting.Builder()
        .name("Emojis")
        .description("allows you to use a few emojis using :emojiname:")
            .defaultValue(false)
        .build()
    );
    private void EmojiTable(GuiTheme theme, WTable table) {
        table.clear();
        List<String> emojislist = new ArrayList<>();
        emojislist.add("Emojis: ");
        emojislist.add("skull");
        emojislist.add("meteor");
        emojislist.add("check");
        emojislist.add("fire");
        emojislist.forEach(s -> {
            WLabel ez = table.add(theme.label(s)).expandCellX().widget();
            ez.visible = true;
            table.row();});
        table.add(theme.horizontalSeparator()).expandX();
        table.row();
    }
    private final Setting<Boolean> bw = sgGeneral.add(new BoolSetting.Builder()
        .name("Backwards")
        .description("backwards messages")
        .defaultValue(false)
        .build()
    );
    @Override
    public WWidget getWidget(GuiTheme theme) {
        WTable table = theme.table();
        EmojiTable(theme, table);
        return table;
    }
    @EventHandler
    private void onMessageSend(SendMessageEvent event) {
        String msg = event.message;
        if (emojis.get()) msg = ChatModificationUtils.setEmojis(msg);
        if (bw.get()) msg = new StringBuilder(msg).reverse().toString();
        event.message = msg;
    }
}
