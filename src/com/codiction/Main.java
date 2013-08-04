/*
 * === CODICTION LICENSE ===
 * License: http://codiction.com/redirect.php?do=cbase_license
 * If you do not agree to the terms refrain yourself from using this library!
 */
package com.codiction;

import com.codiction.arenas.ArenaManager;
import com.codiction.arenas.creation.InfoTool;
import com.codiction.listeners.PlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Codiction
 */
public class Main extends JavaPlugin {

    PlayerListener playerListener;
    private InfoTool it;
    private ArenaManager am;
    
    public Main() {}

    @Override
    public void onEnable() {
        getCommand("arena").setExecutor(new CommandHandler());
        init();
    }
    
    private void init() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdir();
            saveDefaultConfig();
        }
        info(ChatColor.BLUE + "Assigning command handler to /arena");
        it = new InfoTool();
        am = new ArenaManager();
        createListeners();
    }
    
    public ArenaManager getArenaManager() {
        return am;
    }
    
    public InfoTool getInfoTool() {
        if(it == null) {
            it = new InfoTool();
        }
        return it;
    }

    @Override
    public void onDisable() {
        
    }

    public void info(String msg) {
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes("&".charAt(0), "<" + ChatColor.DARK_AQUA + getName() + ChatColor.RESET + "> " + msg) + ChatColor.RESET);
    }
    
    private void createListeners() {
        playerListener = new PlayerListener(this);
    }
}
