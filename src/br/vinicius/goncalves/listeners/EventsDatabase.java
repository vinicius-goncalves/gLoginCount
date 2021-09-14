package br.vinicius.goncalves.listeners;

import br.vinicius.goncalves.database.SQLUtils;
import br.vinicius.goncalves.utils.ReflectionUtils;
import br.vinicius.goncalves.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class EventsDatabase implements Listener {

    public List<String> playerArrayList = new ArrayList<>();
    private final Utils utils = new Utils();
    private final ReflectionUtils reflectionUtils = new ReflectionUtils();
    private final SQLUtils sqlUtils = new SQLUtils();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getTitle().equals(utils.withColor("&8Inventory OP"))) {

            if (event.getCurrentItem().getType() == Material.AIR || event.getCurrentItem() == null) return;

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(utils.withColor("&aSetar &7(Clique)"))) {
                if (!playerArrayList.contains(player.getName())) {
                    playerArrayList.add(player.getName());
                    player.sendMessage("Digite o jogador que você quer setar, dê espaço e descreva o valor");
                    player.closeInventory();
                    utils.sendAlert(player, playerArrayList);

                }
            }
        }
    }

    /*
    This is only a code structure. This line code is on development yet;
     */
        @EventHandler
        public void onWrite (AsyncPlayerChatEvent event){
            Player player = event.getPlayer();
            String message = event.getMessage();
            String[] messageSplit = message.split("\\s+");

            if (this.playerArrayList.contains(player.getName())) {
                event.setCancelled(true);

                for (Player targetPlayer : Bukkit.getOnlinePlayers()) {
                    if (messageSplit[0].contains(targetPlayer.getName()) && targetPlayer.isOnline()) {
                        player.sendMessage("Existe");

                        player.sendMessage("Jogador: " + messageSplit[0]);
                        player.sendMessage("Valor: " + messageSplit[1]);
                        this.playerArrayList.remove(player.getName());
                        return;

                    }
                }
            }
        }
    }
