/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.arenas.creation;

import com.codiction.Main;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Codiction
 */
public class SelectionListener extends BukkitRunnable {

    Player player;

    private boolean said;
    private Location lastSelectionMin, lastSelectionMax;

    public SelectionListener(Player p) {
        player = p;
    }

    WorldEditPlugin worldEdit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
    Main main = (Main) Bukkit.getServer().getPluginManager().getPlugin("CMArenas");

    @Override
    public void run() {
        Selection selection = worldEdit.getSelection(player);

        if (selection != null) {
            
            World world = selection.getWorld();
            Location min = selection.getMinimumPoint();
            Location max = selection.getMaximumPoint();

            if(min != lastSelectionMin || max != lastSelectionMax) {
                said = false;
            }
            
            if (!said) {
                player.sendMessage("<CMArenas>: " + "You can create an arena with this selection.");
                said = true;
            }
            lastSelectionMin = min;
            lastSelectionMax = max;
        } else {
            
        }
    }

}
