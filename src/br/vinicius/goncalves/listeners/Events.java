package br.vinicius.goncalves.listeners;

import br.vinicius.goncalves.database.SQLUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    private SQLUtils sqlUtils = new SQLUtils();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(!sqlUtils.containsPlayers(player)) {
            sqlUtils.setPlayer(player);
            player.sendMessage("§aVocê entrou aqui pela primeira vez!");
        }else {
            if(sqlUtils.containsPlayers(player)) {
                sqlUtils.setCount(player, sqlUtils.getCount(player) + 1);
                player.sendMessage("Você tem: " + sqlUtils.getCount(player));

            }
        }
    }
}
