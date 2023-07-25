package de.suptower.championsrift;

import de.suptower.championsrift.listeners.playerJoin;
import de.suptower.championsrift.listeners.playerLeave;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChampionsRift extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Register Listeners
        Bukkit.getPluginManager().registerEvents(new playerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new playerLeave(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
