package br.vinicius.goncalves.commands;

import br.vinicius.goncalves.inventory.InventoryOP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandOP implements CommandExecutor {

    private InventoryOP inventoryOP = new InventoryOP();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Apenas para jogadores in-game.");
            return false;

        }

        Player player = (Player) commandSender;
        if (!player.hasPermission("glogincount.use") || !player.isOp()) {
            player.sendMessage("&cEssa comando é apenas para administradores.");
            return true;

        }

        if (args.length == 0) {
            inventoryOP.openInventoryToPlayerOP(player);
            return true;

        }
        return false;

    }
}
