package br.vinicius.goncalves.commands;

import br.vinicius.goncalves.inventory.InventoryUtils;
import br.vinicius.goncalves.utils.ReflectionUtils;
import br.vinicius.goncalves.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPlayer implements CommandExecutor {

    private final Utils utils = new Utils();
    private InventoryUtils inventoryUtils = new InventoryUtils();

    /* private FileDatabaseUtils fileDatabaseUtils = new FileDatabaseUtils();
    private FileConfiguration fileConfiguration = new FileDatabaseUtils().getFileConfiguration(); */

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            System.out.println("Apenas para jogadores in-game.");
            return false;

        }

        Player player = (Player) commandSender;
        if(args.length == 0) inventoryUtils.openInventoryPersonalizedToPlayer(player);
        return false;

    }
}
