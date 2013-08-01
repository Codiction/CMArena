/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */

package com.codiction.arenas.player;

import org.bukkit.entity.Player;

/**
 *
 * @author Codiction
 */
public class ArenaPlayer {
    
    public Player player;
    private ArenaLocation loc;
    
    public String getName() {
        return player.getDisplayName();
    }
    
    public double getHealth() {
        return player.getHealthScale();
    }
    
    public void setLocation(ArenaLocation loc) {
        this.loc = loc;
        
    }

}
