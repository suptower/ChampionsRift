package de.suptower.championsrift.commands.subcommands;

import de.suptower.championsrift.commands.ChampionsRiftSubCommand;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class InfoCommand extends ChampionsRiftSubCommand {
    @Override
    public String getName() {
        return "info";
    }

    public String getSyntax() {
        return "/crift info";
    }

    @Override
    public String getDescription() {
        return "Returns plugin information";
    }

    @Override
    public void execute(Player player, String[] args) {
        player.sendMessage(Component.text("Champions Rift plugin for Battle Royale."));
    }
}
