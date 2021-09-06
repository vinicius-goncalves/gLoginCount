package br.vinicius.goncalves.utils;

import br.vinicius.goncalves.commands.CommandOP;
import br.vinicius.goncalves.commands.CommandPlayer;
import br.vinicius.goncalves.database.SQLConnection;
import br.vinicius.goncalves.files.FileDatabaseUtils;
import br.vinicius.goncalves.logincount.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

public class RegisterUtils {

    private FileDatabaseUtils fileDatabaseUtils = new FileDatabaseUtils();
    private SQLConnection sqlConnection = new SQLConnection();

    private void setCommand(String command, CommandExecutor commandExecutor) {
        Bukkit.getPluginCommand(command).setExecutor(commandExecutor);

    }

    private void registerCommands() {
        setCommand("loginCount", new CommandPlayer());
        setCommand("glogincount", new CommandOP());

    }

    public void forOnEnable() {
        registerCommands();
        fileDatabaseUtils.createDatabaseFolder();
        fileDatabaseUtils.createDatabaseFile();

        //Database
        sqlConnection.startConnectionWithDatabase();

        //Others
        Main.getPlugin(Main.class).saveDefaultConfig();

    }

    public void forOnDisable() {
        sqlConnection.closeConnectionWithDatabase();

    }
}
