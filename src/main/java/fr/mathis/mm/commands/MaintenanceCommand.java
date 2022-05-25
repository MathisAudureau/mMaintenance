package fr.mathis.mm.commands;

import fr.mathis.api.message.Line;
import fr.mathis.api.utils.enums.Perm;
import fr.mathis.mm.manager.ServerManagement;
import fr.mathis.mm.mMaintenance;
import fr.mathis.mm.utils.enums.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MaintenanceCommand implements CommandExecutor {
    public MaintenanceCommand(mMaintenance plugin) {
        plugin.getCommand("maintenance").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!commandSender.isOp()) {
            commandSender.sendMessage(Perm.NO_PERMISSION.getError());
            return false;
        }

        if(label.equalsIgnoreCase("maintenance")) {

            if(args.length == 1) {
                //Enable Maintenance
                if(args[0].equalsIgnoreCase("on")) {
                    mMaintenance.Enable = true;
                    ServerManagement.kickAllNotAllowed();
                    commandSender.sendMessage(Lang.MAINTENANCE_ENABLED.getLang());

                 //Disable maintenance
                } else if(args[0].equalsIgnoreCase("off")) {
                    mMaintenance.Enable = false;
                    commandSender.sendMessage(Lang.MAINTENANCE_DISABLED.getLang());

                 //Get help
                } else if(args[0].equalsIgnoreCase("help")) {
                    commandSender.sendMessage(Line.chatLine());
                    commandSender.sendMessage("/maintenance on / off");
                    commandSender.sendMessage(Line.chatLine());

                 //Add player
                } else if(args[0].equalsIgnoreCase("add")) {

                  //Remove player
                } else if(args[0].equalsIgnoreCase("remove")) {

                  //Player list
                } else if(args[0].equalsIgnoreCase("list")) {

                }

            }
        } else {
            commandSender.sendMessage(Lang.MAINTENANCE_COMMAND_INVALID.getLang());
        }
        return true;
    }
}
