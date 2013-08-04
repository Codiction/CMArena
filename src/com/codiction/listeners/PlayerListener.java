/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction.listeners;

import com.codiction.Main;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
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
        
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            //event.getPlayer().sendMessage(ChatColor.AQUA + "You clicked a " + ChatColor.BOLD + event.getClickedBlock().getType().toString().toLowerCase().replace("_", ""));
            
            if(event.getPlayer().getItemInHand().getType() == Material.getMaterial(main.getConfig().getInt("toolId"))) {
                main.getInfoTool().generateOverview(event.getPlayer(),main.getArenaManager().getArenaByLocation(event.getClickedBlock().getLocation()));
            }
            
        }
    }
}
