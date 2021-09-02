package br.vinicius.goncalves.inventory;

import br.vinicius.goncalves.messages.MessagesConfig;
import br.vinicius.goncalves.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

    private final Utils utils = new Utils();
    private MessagesConfig messagesConfig = new MessagesConfig();
    private Inventory customInventory = Bukkit.createInventory(null, 3 * 9, this.utils.withColor("&8Login Count"));

    public void openInventoryPersonalizedToPlayer(Player player) {
        setItemsOnInventory(customInventory, player);
        player.openInventory(customInventory);

    }

    public void setItemsOnInventory(Inventory inventoryToSet, Player player) {
        inventoryToSet.setItem(13, utils.setSkull("black_number_nine", "Login Count", new String[] {messagesConfig.contadorLogin(player)}));

    }
}
