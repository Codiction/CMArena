/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */

package com.codiction.arenas;

import com.codiction.Main;
import com.codiction.listeners.PlayerListener;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;

/**
 *
 * @author Codiction
 */
public class ArenaManager {

    
    Main main = (Main) Bukkit.getServer().getPluginManager().getPlugin("CMArenas");
    
    private List<Arena> arenaList = new ArrayList();
    
    public ArenaManager() {
        
    }
    
    
}
