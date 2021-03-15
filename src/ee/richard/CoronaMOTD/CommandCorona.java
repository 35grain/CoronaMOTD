package ee.richard.CoronaMOTD;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

public class CommandCorona implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof BlockCommandSender)) {
            try {
                sender.sendMessage("Daily cases for " + ParseJSON.dateOfData() + ": " + ParseJSON.dailyCases());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
