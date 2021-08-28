package br.vinicius.goncalves.database;

import br.vinicius.goncalves.logincount.Main;
import org.bukkit.Bukkit;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLConnection {

    public static Connection connection = null;

    public void startConnectionWithSQLite() {
        try {
            File file = new File(Main.getPlugin(Main.class).getDataFolder().toString(), "database.db");
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+file);
            System.out.println("CONECTADO");
            this.createTableIfNotExists();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnectionWithSQLite(){
        try {
            if(!connection.isClosed()) {
                connection.close();
                System.out.println("FECHADO");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void createTableIfNotExists() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `jogadores`(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `jogador` VARCHAR(17) NOT NULL, `loginCount` INT NOT NULL)");
            preparedStatement.executeUpdate();
            System.out.println("CRIADO OU CONECTADO");
        }catch(SQLException e) {
            System.out.println("ERRADO");
            e.printStackTrace();
        }
    }
}
