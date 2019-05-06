package xyz.exwundee.CrashPatch.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.HashMap;

/**
 **     Created by x1D on 05-06-2019.
 **/
public class eOffhandCheck implements Listener {

    public static HashMap<Player, Long> lastChange = new HashMap<>();
    public static HashMap<Player, Integer> warnings = new HashMap<>();

    @EventHandler
    public void onMainHandChange(PlayerSwapHandItemsEvent event) {
        if (lastChange.get(event.getPlayer()) != null && lastChange.get(event.getPlayer()) + 250 > System.currentTimeMillis()) {
            warnings.put(event.getPlayer(), warnings.get(event.getPlayer()) + 1);
            event.getPlayer().sendMessage("§cPlease slow down or you will be kicked. (" + warnings.get(event.getPlayer()) + "/5)");
            if (warnings.get(event.getPlayer()) > 4) {
                event.getPlayer().kickPlayer("§4§lanti riga exploit\n§7by x1D");
                warnings.put(event.getPlayer(), 0);
            }
        }
        lastChange.put(event.getPlayer(), System.currentTimeMillis());
    }

}
