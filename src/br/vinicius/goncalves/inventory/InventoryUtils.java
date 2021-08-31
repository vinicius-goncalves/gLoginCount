package br.vinicius.goncalves.inventory;

import br.vinicius.goncalves.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

    private final Utils utils = new Utils();
    private Inventory customInventory = Bukkit.createInventory(null, 3 * 9, this.utils.withColor("&8Login Count"));

    public void openInventoryPersonalizedToPlayer(Player player) {
        setItemsOnInventory(customInventory);
        player.openInventory(customInventory);

    }

    public void setItemsOnInventory(Inventory inventoryToSet) {
        inventoryToSet.setItem(13, new ItemStack(Material.STONE));

    }
}
