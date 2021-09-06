package br.vinicius.goncalves.listeners;

import br.vinicius.goncalves.database.SQLUtils;
import br.vinicius.goncalves.logincount.Main;
import br.vinicius.goncalves.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    private SQLUtils sqlUtils = new SQLUtils();
    private Utils utils = new Utils();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(!sqlUtils.containsPlayers(player)) {
            sqlUtils.setPlayer(player);
            player.sendMessage(utils.withColor("&aVocê entrou aqui pela primeira vez!"));
        }else {
            if(sqlUtils.containsPlayers(player)) {
                sqlUtils.setCount(player, sqlUtils.getCount(player) + 1);
                player.sendMessage(utils.withColor("&aVocê entrou nesse servidor &f" + sqlUtils.getCount(player) + "&a vezes."));
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        if(inventoryClickEvent.getWhoClicked() instanceof Player) {
            Player player = (Player) inventoryClickEvent.getWhoClicked();
            if(inventoryClickEvent.getInventory().getTitle().equals(utils.withColor("&8Login Count"))) {
                inventoryClickEvent.setCancelled(true);

                if(inventoryClickEvent.getCurrentItem().getType() == Material.AIR || inventoryClickEvent.getCurrentItem() == null) return;
            }

            if(inventoryClickEvent.getInventory().getTitle().equals(utils.withColor("&8Inventory OP"))) {
                inventoryClickEvent.setCancelled(true);

                if(inventoryClickEvent.getCurrentItem().getType() == Material.AIR || inventoryClickEvent.getCurrentItem() == null) return;

                if(inventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName().equals(utils.withColor("&aReiniciar"))) {
                    Main.getPlugin(Main.class).reloadConfig();
                    player.sendMessage(utils.withColor("&aA configuração foi recarregada."));
                    player.closeInventory();

                }
            }
        }
    }
}
