package de.suptower.championsrift.commands.subcommands;

import de.suptower.championsrift.ChampionsRift;
import de.suptower.championsrift.commands.ChampionsRiftSubCommand;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InfoCommand extends ChampionsRiftSubCommand {

    public InfoCommand(String name) {
        super(name);
        this.description = getDescription();
        this.usageMessage = getSyntax();
        this.setPermission("crift.info");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        print(commandSender, "Champions Rift plugin for Battle Royale.");
        return true;
    }

    @Override
    public String getName() {
        return "crift:info";
    }

    public String getSyntax() {
        return "/crift:info";
    }

    @Override
    public String getDescription() {
        return "Returns ChampionsRift plugin information";
    }

}
