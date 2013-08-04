/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Codiction
 */
public class CommandHandler implements CommandExecutor {

    Main main = (Main) Bukkit.getServer().getPluginManager().getPlugin("CMArenas");
    WorldEditPlugin worldEdit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String label, String[] args) {
        if (args.length == 0) {
            return false;
        } else {
            if (args[0].equalsIgnoreCase("help")) {
                try {
                    showHelp(cs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("create")) {
                cs.sendMessage("length: " + args.length);
                if (args.length == 2) {
                    Selection selection = worldEdit.getSelection(Bukkit.getPlayer(cs.getName()));
                    cs.sendMessage("args 1: " + args[1]);
                    Player p = Bukkit.getPlayer(cs.getName());
                    
                    main.getArenaManager().createArena(selection, args[1], cs.getName(), p.getWorld().getName());
                    
                    cs.sendMessage("Arena '" + args[1] + "' created. You can now use the info tool.");
                    return true;
                }
            }
        }
        return false;
    }

    private void showHelp(CommandSender cs) {
    }

    private void msg(String msg, CommandSender cs) {
        cs.sendMessage(ChatColor.translateAlternateColorCodes("&".charAt(0), msg));
    }

}
