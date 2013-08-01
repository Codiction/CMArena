/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */

package com.codiction;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Codiction
 */
public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String label, String[] args) {
        if(args.length == 0) {
            return false;
        } else {
            if(args[0].equalsIgnoreCase("help")) {
                
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
