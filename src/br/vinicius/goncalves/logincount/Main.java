package br.vinicius.goncalves.logincount;

import br.vinicius.goncalves.logincount.utils.ReflectionUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        ReflectionUtils reflectionUtils = new ReflectionUtils();
        Bukkit.getConsoleSender().sendMessage("§aPlugin iniciado.");
        for(Player player : Bukkit.getOnlinePlayers()) {
            try {
                reflectionUtils.sendTitleToPlayer(player, "TESTE", "", 30, 60, 30);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("§6Plugin carregando...");

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cPlugin desligado.");

    }
}
