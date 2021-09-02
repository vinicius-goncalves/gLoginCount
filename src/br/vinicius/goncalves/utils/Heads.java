package br.vinicius.goncalves.utils;

import org.bukkit.inventory.ItemStack;

public enum Heads {

    BLACK_NUMBER_NINE("OWY3YWEwZDk3OTgzY2Q2N2RmYjY3YjdkOWQ5YzY0MWJjOWFhMzRkOTY2MzJmMzcyZDI2ZmVlMTlmNzFmOGI3In19fQ==", "black_number_nine");

    String value = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
    String nameHead;
    ItemStack itemStack;

    Heads(String texture, String nameHead) {
        HeadsUtils headsUtils = new HeadsUtils();
        itemStack = headsUtils.createHead(value + texture, nameHead);
        this.nameHead = nameHead;

    }

    public String getNameHead() {
        return nameHead;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

}
