package xyz.exwundee.CrashPatch.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 **     Created by x1D on 05-06-2019.
 **/
public class eJoinLeaveEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        eOffhandCheck.lastChange.put(event.getPlayer(), System.currentTimeMillis());
        eOffhandCheck.warnings.put(event.getPlayer(), 0);
    }

}
