/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.listeners;

import com.codiction.Main;
import com.codiction.arenas.creation.SelectionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author Codiction
 */
public class PlayerListener implements Listener {
    
    private HashMap<Player, BukkitTask> tasks = new HashMap();
    Main main;
    public PlayerListener(Main m) {
        main = m;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        BukkitTask task = new SelectionListener(event.getPlayer()).runTaskTimer(main, 100, 10);
        
        tasks.put(event.getPlayer(), task);
        main.info("Running task for: " + event.getPlayer().getName());
    }
    
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        BukkitTask task = tasks.get(event.getPlayer());
        task.cancel();
        main.info("Stopped task for quitting user: " + event.getPlayer().getName());
    }
}
