/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.arenas;

import com.codiction.arenas.player.ArenaPlayer;
import com.sk89q.worldedit.bukkit.selections.Selection;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 *
 * @author Codiction
 */
public class Arena {

    private List<ArenaPlayer> playerList = new ArrayList();

    private Location min, max;
    private String owner;
    private String arenaName;
    private String world;

    public ArenaPlayer getPlayer(String name) {
        for (ArenaPlayer player : playerList) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public boolean isLocationInArena(Location loc) {
        System.out.println("Min: " + min.toString() + "\nMax: " + max.toString() + "\nSelected: " + loc.toString());
        ArenaVector curr = new ArenaVector(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        ArenaVector mino = new ArenaVector(Math.min(min.getBlockX(), max.getBlockX()), Math.min(min.getBlockY(), max.getBlockY()), Math.min(min.getBlockZ(), max.getBlockZ()));
        ArenaVector maxo = new ArenaVector(Math.max(min.getBlockX(), max.getBlockX()), Math.max(min.getBlockY(), max.getBlockY()), Math.max(min.getBlockZ(), max.getBlockZ()));
        return curr.isInAABB(mino, maxo);
    }

    public Arena(Selection s, String owner, String name, String wo) {
        world = wo;
        arenaName = name;
        this.owner = owner;
        min = s.getMinimumPoint();
        max = s.getMaximumPoint();
    }
    
    public Arena() {
        
    }
    
    public void setCoordinates(Location min, Location max) {
        this.min = min;
        this.max = max;
    }
    
    public Location createCoordinate(int x,int y,int z) {
        World w = Bukkit.getWorld(getWorld());
        Location l = new Location(w, (double) x, (double) y, (double) z);
        return l;
    }
    
    public void setName(String name) {
        arenaName = name;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public Location getMin() {
        return min;
    }
    
    public Location getMax() {
        return max;
    }
    
    public String getName() {
        return arenaName;
    }
    
    public void setWorld(String n) {
        world = n;
    }
    
    public String getWorld() {
        return world;
    }

    public String getOwner() {
        return owner;
    }

}
