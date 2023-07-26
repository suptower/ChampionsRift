package de.suptower.championsrift.commands;

import de.suptower.championsrift.commands.subcommands.InfoCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChampionsRiftCommandManager implements CommandExecutor {

    private ArrayList<ChampionsRiftSubCommand> subCommands = new ArrayList<>();

    public ChampionsRiftCommandManager() {
        subCommands.add(new InfoCommand());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if (strings.length > 0) {
                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (strings[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                        getSubCommands().get(i).execute(p, strings);
                    }
                }
            } else {
                p.sendMessage(Component.text("----------"));
                for (int i = 0; i < getSubCommands().size(); i++) {
                    Component infoText = Component.text()
                            .content(getSubCommands().get(i).getName())
                            .color(TextColor.color(NamedTextColor.DARK_AQUA))
                            .append(Component.text().content(" - ").color(TextColor.color(NamedTextColor.WHITE)))
                            .append(Component.text().content(getSubCommands().get(i).getDescription()).color(TextColor.color(NamedTextColor.GREEN)))
                            .build();
                    p.sendMessage(infoText);
                }
                p.sendMessage(Component.text("----------"));
            }
        }
        return true;
    }

    public ArrayList<ChampionsRiftSubCommand> getSubCommands() {
        return subCommands;
    }
}
