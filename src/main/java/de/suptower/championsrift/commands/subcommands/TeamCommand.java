package de.suptower.championsrift.commands.subcommands;

import de.suptower.championsrift.ChampionsRift;
import de.suptower.championsrift.commands.ChampionsRiftSubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.*;

public class TeamCommand extends ChampionsRiftSubCommand implements Listener {

    private final Inventory teamInv;

    public TeamCommand(String name) {
        super(name);
        teamInv = Bukkit.createInventory(null, InventoryType.CHEST, Component.text().content("ChampionsRift Teams").color(TextColor.color(NamedTextColor.GOLD)).build());
        this.description = getDescription();
        this.usageMessage = getSyntax();
        this.setPermission("crift.team");
    }
    @Override
    public String getName() {
        return "crift:team";
    }

    @Override
    public String getSyntax() {
        return "/crift:team [add|delete|options|setup|clear] <args>";
    }

    @Override
    public String getDescription() {
        return "ChampionsRift Team Command";
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args)  {
        openTeamInventory(sender);
        return true;
    }

    private void openTeamInventory(CommandSender sender) {

        // information to inventory
        // https://www.spigotmc.org/wiki/creating-a-gui-inventory/
        // https://jd.papermc.io/paper/1.20/org/bukkit/Bukkit.html for creating inventories

        // Create Item Stack
        ItemStack createItemStack = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta createItemMeta = createItemStack.getItemMeta();
        createItemMeta.displayName(Component.text("Create Team"));
        createItemMeta.lore(Collections.singletonList(Component.text("Create a new Team")));
        createItemStack.setItemMeta(createItemMeta);

        // Set Create Item
        teamInv.setItem(10, createItemStack);

        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.openInventory(teamInv);
        }
    }

    @EventHandler
    public void onItemClick(final InventoryClickEvent e) {
        if (!Objects.equals(e.getClickedInventory(), teamInv)) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item exists
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        // Slot to identify
        if (e.getRawSlot() == 10) {
            // iron sword
            p.closeInventory();
            ItemStack giveStack = new ItemStack(Material.DIAMOND_SWORD,1);
            p.getInventory().addItem(giveStack);
        }
    }

    public void addTeam(CommandSender sender, String[] args) {
        if (args.length == 1) {
            print(sender, getSyntax());
        } else {
            // Get Main Scoreboard
            Scoreboard mainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

            // Get list of Teams

            // Check if Team already exists
        }
    }
}
