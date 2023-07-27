package de.suptower.championsrift.commands;

import de.suptower.championsrift.commands.subcommands.InfoCommand;
import de.suptower.championsrift.commands.subcommands.TeamCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.*;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ChampionsRiftCommandManager extends BukkitCommand {

    private ArrayList<ChampionsRiftSubCommand> subCommands = new ArrayList<>();

    public ChampionsRiftCommandManager(String name) {
        super(name);
        this.description = "Main command for Champions Rift plugin.";
        this.usageMessage = "/crift <args>";
        this.setPermission("crift.main");
        initializeSubcommands();
    }

    public void initializeSubcommands() {
        subCommands.add(new InfoCommand("info"));
        subCommands.add(new TeamCommand("info"));
    }

    public ArrayList<ChampionsRiftSubCommand> getSubCommands() {
        return subCommands;
    }

    public ChampionsRiftSubCommand getSubCommand(String name) {
        for (ChampionsRiftSubCommand subCommand : subCommands) {
            if (subCommand.getName().equalsIgnoreCase(name)) {
                return subCommand;
            }
        }
        return null;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (strings.length > 0) {
            for (int i = 0; i < getSubCommands().size(); i++) {
                if (strings[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                    getSubCommands().get(i).execute(commandSender, s, strings);
                }
            }
        } else {
            if (commandSender instanceof Player) {
                commandSender.sendMessage(Component.text("----------"));
                for (int i = 0; i < getSubCommands().size(); i++) {
                    Component infoText = Component.text()
                            .content(getSubCommands().get(i).getSyntax())
                            .color(TextColor.color(NamedTextColor.DARK_AQUA))
                            .append(Component.text().content(" - ").color(TextColor.color(NamedTextColor.WHITE)))
                            .append(Component.text().content(getSubCommands().get(i).getDescription()).color(TextColor.color(NamedTextColor.GREEN)))
                            .build();
                    commandSender.sendMessage(infoText);
                }
                commandSender.sendMessage(Component.text("----------"));
            } else if (commandSender instanceof RemoteConsoleCommandSender || commandSender instanceof ConsoleCommandSender) {
                System.out.println("Command Overview can only be accessed by Players");
            }

        }
        return true;
    }
}
