package br.vinicius.goncalves.logincount.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class ReflectionUtils {

    public Class<?> getNMSClass(String name) {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        try {
            return Class.forName("net.minecraft.server." + version + "." + name);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendPacket(Player player, Object packet) throws Exception {
        Object getHandle = player.getClass().getMethod("getHandle").invoke(player);
        Object playerConnection = getHandle.getClass().getField("playerConnection").get(getHandle);
        playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);

    }

    public void sendTitleToPlayer(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) throws Exception {
        Object titleObject = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getDeclaredField("TITLE").get(null);
        Object titleChat = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\""+title+"\"}");

        Constructor<?> constructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);

        Object titlePacket = constructor.newInstance(titleObject, titleChat, fadeIn, stay, fadeOut);

        sendPacket(player, titlePacket);

    }
}
