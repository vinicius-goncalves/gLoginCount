package br.vinicius.goncalves.database;

import br.vinicius.goncalves.files.FileDatabaseUtils;
import br.vinicius.goncalves.logincount.Main;
import br.vinicius.goncalves.utils.Utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLConnection {

    public static Connection connection = null;
    private final File file = new File("plugins/gLoginCount/database/database.db");
    private final FileDatabaseUtils fileDatabaseUtils = new FileDatabaseUtils();
    private final Utils utils = new Utils();

    public void startConnectionWithDatabase() {

        if (fileDatabaseUtils.getFileConfiguration().getBoolean("usarMySQL")) {
            utils.sendMessageToConsole("&aTodos os dados serao salvos em um banco de dados MySQL [Connection]");
        } else {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:" + file);
                utils.sendMessageToConsole("&aConectado com sucesso ao banco de dados [SQLite].");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        this.createTableIfNotExists();
    }

    public void closeConnectionWithDatabase() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void createTableIfNotExists() {
        if (fileDatabaseUtils.getFileConfiguration().getBoolean("usarMySQL")) {
            utils.sendMessageToConsole("&aTodos os dados serao salvos em um banco de dados MySQL [Table]");
        } else {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `jogadores`(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `jogador` VARCHAR(17) NOT NULL, `loginCount` INT NOT NULL)");
                preparedStatement.executeUpdate();
                utils.sendMessageToConsole("&aA tabela foi criada ou carregada com sucesso [SQLite].");
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
