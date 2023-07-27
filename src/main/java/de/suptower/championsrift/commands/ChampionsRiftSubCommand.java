package de.suptower.championsrift.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public abstract class ChampionsRiftSubCommand extends BukkitCommand {

    public ChampionsRiftSubCommand(String name) {
        super(name);
    }

    public abstract String getName();

    public abstract String getSyntax();

    public abstract String getDescription();

    public abstract boolean execute(CommandSender sender, String alias, String[] args);

    public void print(CommandSender sender, String msg) {
        if (sender instanceof Player) {
            sender.sendMessage(Component.text(msg));
        } else if (sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender) {
            Bukkit.getLogger().log(Level.INFO, msg);
        }
    }
}
