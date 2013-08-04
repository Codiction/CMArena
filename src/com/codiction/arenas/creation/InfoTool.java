/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.arenas.creation;

import com.codiction.arenas.Arena;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 *
 * @author Codiction
 */
public class InfoTool {

    public InfoTool() {
        
    }
    
    public void generateOverview(Player p, Arena arena) {
        if(arena == null && p != null) {
            p.sendMessage("This is not a CMArena arena.");
            return;
        }
        p.sendMessage(ChatColor.RED + "=====[" + ChatColor.GOLD + "ARENA INFO" + ChatColor.RED + "]=====");
        sendline(p, "Name", arena.getName());
        sendline(p, "Owner", arena.getOwner());
        sendline(p, "World", arena.getWorld());
        p.sendMessage(ChatColor.RED + "==============================");
    }
    
    private void sendline(Player p, String key, String val) {
        p.sendMessage(ChatColor.DARK_AQUA + key + ": " + ChatColor.RESET + val);
    }


}
