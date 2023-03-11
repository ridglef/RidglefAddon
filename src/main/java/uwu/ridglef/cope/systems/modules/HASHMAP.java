package uwu.ridglef.cope.systems.modules;

import meteordevelopment.meteorclient.events.game.ReceiveMessageEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.text.Text;
import uwu.ridglef.cope.RidglefAddon;

public class HASHMAP extends Module {
    public HASHMAP() {
        super(RidglefAddon.CATEGORY, "HASHMAP", "HASHMAP HASHMAP HASHMAP HASHMAP");
    }


    @EventHandler
    private void onMessageReceive(ReceiveMessageEvent event) {
        if (event.getIndicator() == null || event.getIndicator().loggedName() == null) return;
        if (event.getMessage().contains(Text.of("what would you do")) || event.getMessage().contains(Text.of("what would you use"))){
            ChatUtils.sendPlayerMsg("HASHMAP");
        }
    }
}
