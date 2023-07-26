package de.suptower.championsrift;

import de.suptower.championsrift.commands.ChampionsRiftCommandManager;
import de.suptower.championsrift.listeners.playerJoin;
import de.suptower.championsrift.listeners.playerLeave;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ChampionsRift extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Register Listeners
        Bukkit.getPluginManager().registerEvents(new playerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new playerLeave(), this);

        // Register Commands
        Objects.requireNonNull(Bukkit.getPluginCommand("crift")).setExecutor(new ChampionsRiftCommandManager());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
