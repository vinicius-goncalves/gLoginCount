package br.vinicius.goncalves.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    private HeadsUtils headsUtils = new HeadsUtils();

    /*
    Many methods
     */
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

    public ItemStack getHead(String headName) {
        return headsUtils.getNameHead(headName);

    }

    public ItemStack setItem(Material material, String[] lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;

    }

    public ItemStack setSkull(String nameHead, String displayName, String[] lore) {
        ItemStack itemStack = headsUtils.getNameHead(nameHead);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§a"+displayName);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;

    }

    /*
    Others
     */
    public String randomString(int sizeString, String stringToRandom) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < sizeString; i++) {
            stringBuilder.append(stringToRandom.charAt(new Random().nextInt(sizeString)));
        }
        return stringBuilder.toString();
    }
}
