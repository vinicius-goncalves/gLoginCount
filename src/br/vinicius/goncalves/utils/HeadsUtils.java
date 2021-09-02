package br.vinicius.goncalves.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class HeadsUtils {

    public ItemStack getNameHead(String nameHead) {
        for(Heads heads : Heads.values()) {
            if(heads.getNameHead().equalsIgnoreCase(nameHead)) {
                return heads.getItemStack();
            }
        }
        return null;
    }

    ItemStack createHead(String texture, String nameHead) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        if (texture.isEmpty()) return itemStack;

        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setDisplayName("§a"+nameHead);
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), null);
        gameProfile.getProperties().put("textures", new Property("textures", texture));

        try {

            Field field = skullMeta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(skullMeta, gameProfile);

        }catch(Exception ignored) {

        }

        itemStack.setItemMeta(skullMeta);
        return itemStack;

    }
}