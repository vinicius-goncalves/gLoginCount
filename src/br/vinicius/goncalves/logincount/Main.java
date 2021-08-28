package br.vinicius.goncalves.logincount;

import br.vinicius.goncalves.database.SQLConnection;
import br.vinicius.goncalves.listeners.Events;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private SQLConnection sqLiteConnection = new SQLConnection();

    @Override
    public void onEnable() {

        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§aPlugin iniciado.");
        sqLiteConnection.startConnectionWithSQLite();
        Bukkit.getPluginManager().registerEvents(new Events(), this);

    }

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("§6Plugin carregando...");

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cPlugin desligado.");
        sqLiteConnection.closeConnectionWithSQLite();

    }
}
