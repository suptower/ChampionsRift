package de.suptower.championsrift.commands;

import org.bukkit.entity.Player;

public abstract class ChampionsRiftSubCommand {

    public abstract String getName();

    public abstract String getSyntax();

    public abstract String getDescription();

    public abstract void execute(Player player, String[] args);
}
