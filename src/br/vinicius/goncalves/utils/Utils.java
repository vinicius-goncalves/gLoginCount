package br.vinicius.goncalves.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Random;

public class Utils {


    public String getPrefix() {
        return withColor("&f[gLoginCount]&r: ");
    }

    public String translateBoolean(boolean booleanValue) {
        return booleanValue?"Sim":"Nao";

    }

    public String withColor(String messageToSend) {
        return ChatColor.translateAlternateColorCodes('&', messageToSend);

    }

    public void sendMessageToConsole(String messageToSend) {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + withColor(messageToSend));


    }

    public String randomString(int sizeString, String stringToRandom) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < sizeString; i++) {
            stringBuilder.append(stringToRandom.charAt(new Random().nextInt(sizeString)));
        }
        return stringBuilder.toString();
    }
}
