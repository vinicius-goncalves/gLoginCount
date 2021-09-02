package br.vinicius.goncalves.messages;

import br.vinicius.goncalves.database.SQLUtils;
import br.vinicius.goncalves.logincount.Main;
import br.vinicius.goncalves.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessagesConfig {

    private Main main = (Main) Bukkit.getPluginManager().getPlugin("gLoginCount");
    private SQLUtils sqlUtils = new SQLUtils();
    private Utils utils = new Utils();

    public String contadorLogin(Player player) {
        return this.getMessageWithConfig("contadorLogin")
                .replace("%glogincount_player%", String.valueOf(sqlUtils.getCount(player)))
                .replace("%glogincount_server%", Bukkit.getServer().getServerName())
                .replace("%glogincount_playername%", player.getName());

    }

    public String getMessageWithConfig(String path) {
        return main.getConfig().getString(path).replace('&', '§');


    }
}
