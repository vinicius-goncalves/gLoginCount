package br.vinicius.goncalves.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class ReflectionUtils {

    public Class<?> getNMSClass(String name) {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        try {
            return Class.forName("net.minecraft.server." + version + "." + name);
        }catch(Exception e) {

        }
        return null;
    }

    public void sendPacket(Player player, Object packet) throws Exception {
        Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
        Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
        playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);

    }

    public void sendTitle(Player player, String title, int fadeIn, int stay, int fadeOut) {
        try {
            Object titleObject = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
            Object titleChat = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\""+title+"\"}");

            Constructor<?> constructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);

            Object titlePacket = constructor.newInstance(titleObject, titleChat, fadeIn, stay, fadeOut);

            sendPacket(player, titlePacket);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void sendActionbar(Player player, String message) {
        try {
            Object actionbarChat = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\""+message+"\"}");
            Constructor<?> constructor = getNMSClass("PacketPlayOutChat").getConstructor(getNMSClass("IChatBaseComponent"), byte.class);
            Object actionbarPacket = constructor.newInstance(actionbarChat, (byte) 2);

            sendPacket(player, actionbarPacket);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
