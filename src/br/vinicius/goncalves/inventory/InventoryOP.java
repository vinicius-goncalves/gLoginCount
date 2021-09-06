package br.vinicius.goncalves.inventory;

import br.vinicius.goncalves.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryOP {

    private final Utils utils = new Utils();
    private Inventory inventory = Bukkit.createInventory(null, 3 * 9, utils.withColor("&8Inventory OP"));

    public void openInventoryToPlayerOP(Player player) {
        setItemsOnInventory(inventory);
        player.openInventory(inventory);

    }

    public void setItemsOnInventory(Inventory inventoryToSet) {
        inventoryToSet.setItem(12, utils.setSkull("black_question", "&aSetar &7(Clique)", new String[] {"&7Em breve".replace('&', '§')}));
        inventoryToSet.setItem(14, utils.setSkull("black_exclamation", "&aReiniciar", new String[] {"&7Reiniciar configurações".replace('&', '§')}));

    }
}
