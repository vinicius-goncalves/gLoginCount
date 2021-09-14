//This plugin is in development;
package br.vinicius.goncalves.logincount;

import br.vinicius.goncalves.database.SQLConnection;
import br.vinicius.goncalves.files.FileDatabaseUtils;
import br.vinicius.goncalves.listeners.Events;
import br.vinicius.goncalves.listeners.EventsDatabase;
import br.vinicius.goncalves.utils.RegisterUtils;
import br.vinicius.goncalves.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final RegisterUtils registerUtils = new RegisterUtils();
    private SQLConnection sqLiteConnection = new SQLConnection();
    private FileDatabaseUtils fileDatabaseUtils = new FileDatabaseUtils();

    private final Utils utils = new Utils();

    @Override
    public void onEnable() {

        registerUtils.forOnEnable();
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new EventsDatabase(), this);


    }

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("§6Plugin carregando...");

    }

    @Override
    public void onDisable() {
        registerUtils.forOnDisable();

    }
}
