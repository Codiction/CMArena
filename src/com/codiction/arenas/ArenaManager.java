/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.arenas;

import com.codiction.Main;
import com.sk89q.worldedit.bukkit.selections.Selection;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author Codiction
 */
public class ArenaManager {

    Main main = (Main) Bukkit.getServer().getPluginManager().getPlugin("CMArenas");

    private List<Arena> arenaList = new ArrayList();

    public ArenaManager() {
        main.info("ArenaManager online.");
        main.info(ChatColor.GOLD + "Loading arenas...");
        loadArenas();
    }

    public void loadArenas() {
        File basePath = main.getDataFolder();
        if (!basePath.exists()) {
            createStructure(basePath);
        }
        
        String arenaPath = main.getDataFolder().getPath() + "\\arenas\\";
        
        File arenaFolder = new File(arenaPath);
        
        for(File f : arenaFolder.listFiles()) {
            if(f.getPath().endsWith(".yml")) {
                loadArena(f);
            }
        }
    }
    
    private void loadArena(File f) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
        Arena a = new Arena();
        
        a.setWorld(config.getString("world"));
        
        Location min = a.createCoordinate(config.getInt("min.x"), config.getInt("min.y"), config.getInt("min.z"));
        Location max = a.createCoordinate(config.getInt("max.x"), config.getInt("max.y"), config.getInt("max.z"));
        
        a.setCoordinates(min, max);
        a.setName(config.getString("name"));
        a.setOwner(config.getString("owner"));
        
        arenaList.add(a);
        main.info("Added: " + a.getName() + " to the list of arenas");
    }
    
    public Arena getArenaByLocation(Location loc) {
        for(Arena arena : arenaList) {
            if(arena.isLocationInArena(loc)) {
                return arena;
            }
        }
        
        return null;
    }

    private void createStructure(File path) {
        path.mkdirs();
        String arenaPath = path.getPath() + "\\arenas\\";
        File arenaPathToFile = new File(arenaPath);
        arenaPathToFile.mkdirs();
    }
    
    public void createArena(Selection s, String name, String owner, String world) {
        if(s == null) {
            System.out.println("Selection is null");
            return;
        } else if(name.equals("")) {
            return;
        } else if(owner.equals("")) {
            return;
        }
        if(arenaList == null) {
            return;
        }
        Arena arena = new Arena(s, owner, name, world);
        saveArena(arena);
        arenaList.add(arena);
    }
    
    public void saveArena(Arena a) {
        if(a == null) return;
        
        String arenaPath = main.getDataFolder().getPath() + "\\arenas\\";
        File arenaFile = new File(arenaPath + a.getName() + ".yml");
        
        FileConfiguration conf = YamlConfiguration.loadConfiguration(arenaFile);
        
        conf.set("name", a.getName());
        conf.set("owner", a.getOwner());
        conf.set("world", a.getWorld());
        conf.set("min.x", a.getMin().getBlockX());
        conf.set("min.y", a.getMin().getBlockY());
        conf.set("min.z", a.getMin().getBlockZ());
        conf.set("max.x", a.getMax().getBlockX());
        conf.set("max.y", a.getMax().getBlockY());
        conf.set("max.z", a.getMax().getBlockZ());
        try {
            conf.save(arenaFile);
        } catch (IOException ex) {
            main.info(ChatColor.RED + "Could not save the arena file for " + a.getName());
        }
    }

}
