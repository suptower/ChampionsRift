package de.suptower.championsrift.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final TextComponent joinText = Component.text()
                .content(event.getPlayer().getName())
                .color(TextColor.color(NamedTextColor.GOLD))
                .append(Component.text().content(" has").color(TextColor.color(NamedTextColor.DARK_AQUA)))
                .append(Component.text().content(" joined").color(TextColor.color(NamedTextColor.GREEN)))
                .append(Component.text().content(" the Rift.").color(TextColor.color(NamedTextColor.DARK_AQUA)))
                .build();
        event.joinMessage(joinText);
    }
}
