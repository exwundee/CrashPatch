package xyz.exwundee.CrashPatch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.exwundee.CrashPatch.events.eJoinLeaveEvents;
import xyz.exwundee.CrashPatch.events.eOffhandCheck;

/**
 **     Created by x1D on 05-06-2019.
 **/
public class CrashPatch extends JavaPlugin {

    @Override
    public void onEnable() {
        registerEvents(this, new eOffhandCheck(), new eJoinLeaveEvents());
        for (Player player : Bukkit.getOnlinePlayers()) {
            eOffhandCheck.lastChange.put(player, System.currentTimeMillis());
            eOffhandCheck.warnings.put(player, 0);
        }
    }

    public void registerEvents(Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


}
