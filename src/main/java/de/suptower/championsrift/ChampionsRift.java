package de.suptower.championsrift;

import de.suptower.championsrift.commands.ChampionsRiftCommandManager;
import de.suptower.championsrift.commands.ChampionsRiftSubCommand;
import de.suptower.championsrift.commands.subcommands.InfoCommand;
import de.suptower.championsrift.commands.subcommands.TeamCommand;
import de.suptower.championsrift.listeners.playerJoin;
import de.suptower.championsrift.listeners.playerLeave;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public final class ChampionsRift extends JavaPlugin implements Listener {

    public static ChampionsRift instance;
    public static ChampionsRiftCommandManager commandManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Register Listeners
        registerListeners();

        // Register Commands
        registerCommands();
    }

    @Override
    public void onLoad() {
        instance = this;
        commandManager = new ChampionsRiftCommandManager("CHAMPIONSRIFT_COMMAND_MANAGER");
        super.onLoad();
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new playerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new playerLeave(), this);
        Bukkit.getPluginManager().registerEvents((Listener) commandManager.getSubCommand("crift:team"), this);
    }

    public void registerCommands() {
        // https://www.spigotmc.org/threads/small-easy-register-command-without-plugin-yml.38036/
        this.getServer().getCommandMap().register("crift", new ChampionsRiftCommandManager("crift"));
        this.getServer().getCommandMap().register("crift", commandManager.getSubCommand("crift:info"));
        this.getServer().getCommandMap().register("crift", commandManager.getSubCommand("crift:team"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ChampionsRift getInstance() {
        return instance;
    }
}
