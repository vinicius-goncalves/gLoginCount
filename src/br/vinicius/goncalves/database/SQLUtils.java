package br.vinicius.goncalves.database;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtils extends SQLConnection {

    public boolean containsPlayers(Player player) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `jogador` = ?");
            preparedStatement.setString(1, player.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            return false;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void setPlayer(Player player) {
        if(!containsPlayers(player)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `jogadores`(`jogador`, `loginCount`) VALUES (?, ?)");
                preparedStatement.setString(1, player.getName());
                preparedStatement.setInt(2, 0);
                preparedStatement.executeUpdate();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount(Player player) {
        if(containsPlayers(player)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `jogadores` WHERE `jogador` = ?");
                preparedStatement.setString(1, player.getName());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    return resultSet.getInt("loginCount");
                }
                return 0;
            }catch(SQLException e) {
                e.printStackTrace();
                return 0;

            }
        }else {
            setPlayer(player);
            return 0;
        }
    }

    public void setCount(Player player, int howMany) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `jogadores` SET `loginCount` = ? WHERE `jogador` = ? ");
            preparedStatement.setInt(1, howMany);
            preparedStatement.setString(2, player.getName());
            preparedStatement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
