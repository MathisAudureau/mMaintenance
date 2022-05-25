package fr.mathis.mm.commands;

import fr.mathis.api.message.Line;
import fr.mathis.api.utils.enums.Perm;
import fr.mathis.mm.manager.ServerManagement;
import fr.mathis.mm.mMaintenance;
import fr.mathis.mm.utils.enums.Lang;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

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
                if(args[0].equalsIgnoreCase("on")) {
                    mMaintenance.Enable = true;
                    ServerManagement.kickAllNotAllowed();
                    commandSender.sendMessage(Lang.MAINTENANCE_ENABLED.getLang());

                } else if(args[0].equalsIgnoreCase("off")) {
                    mMaintenance.Enable = false;
                    commandSender.sendMessage(Lang.MAINTENANCE_DISABLED.getLang());

                } else if(args[0].equalsIgnoreCase("help")) {
                    commandSender.sendMessage(Line.chatLine());
                    commandSender.sendMessage("/maintenance on / off");
                    commandSender.sendMessage(Line.chatLine());

                } else if(args[0].equalsIgnoreCase("list")) {
                    OfflinePlayer player;
                    for(UUID uuid: mMaintenance.getAuthorized()) {
                        player = Bukkit.getOfflinePlayer(uuid);
                        if(player != null) {
                            commandSender.sendMessage(Line.chatLine());
                            commandSender.sendMessage("§a+ §r" + player.getName());
                            commandSender.sendMessage(Line.chatLine());
                        } else {
                            commandSender.sendMessage(Line.chatLine());
                            commandSender.sendMessage("§cAucun joueur enregistré dans la withlist.");
                            commandSender.sendMessage(Line.chatLine());
                        }
                    }
                }
            } else if(args.length == 2) {
                if(args[0].equalsIgnoreCase("add")) {
                    final String playerName = args[1];
                    final Player player = Bukkit.getPlayerExact(playerName);
                    if(player != null) {
                        final UUID uuid = player.getUniqueId();
                        mMaintenance.getAuthorized().add(uuid);
                        commandSender.sendMessage(Lang.USER_ADD.getLang());
                    } else {
                        commandSender.sendMessage("§cLe joueur n'est actuellement pas connecté.");
                    }

                } else if(args[0].equalsIgnoreCase("remove")) {
                    final String playerName = args[1];
                    final Player player = Bukkit.getPlayerExact(playerName);
                    if(player != null) {
                        final UUID uuid = player.getUniqueId();
                        mMaintenance.getAuthorized().remove(uuid);
                        commandSender.sendMessage(Lang.USER_REMOVE.getLang());
                    } else {
                        commandSender.sendMessage("§cLe joueur n'est actuellement pas connecté.");
                    }
                }
            }
        } else {
            commandSender.sendMessage(Lang.MAINTENANCE_COMMAND_INVALID.getLang());
        }
        return true;
    }
}
