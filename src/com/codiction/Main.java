/*
 * ==== CMCore License V1.0 ====
 * 
 * This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ or send a letter to
 * Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 * 
 * If you do not agree to the license, please do not use this software.
 * Removing this license text is NOT allowed.
 */
package com.codiction;

import com.codiction.economy.CMEconomy;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Codiction
 */
public class Main extends JavaPlugin {

    private FileConfiguration config;
    private boolean economy, shoutcaster, illusia;
    private String configuredVersion;
    
    private CMEconomy cmEconomy;
    
    public static boolean DEBUG = true;

    @Override
    public void onEnable() {
        initConfiguration();
    }
    
    public void info(String msg) {
        getLogger().info(ChatColor.translateAlternateColorCodes("&".charAt(0), msg));
    }

    /**
     * Initializes the configuration of the core (config.yml)
     */
    public void initConfiguration() {
        if (!this.getDataFolder().exists()) {
            info("&3Configuration file is not found, creating new one...&r");
            this.saveDefaultConfig();
        } else {
            config = this.getConfig();
            info("&3Loading configuration...&r");
        }

        configuredVersion = config.getString("version");

        if (!configuredVersion.equals(this.getDescription().getVersion())) {
            getLogger().severe(ChatColor.RED + "The configuration file cannot be used with this version of CMCore ("
                    + ChatColor.DARK_GREEN + this.getDescription().getVersion());
            stopPlugin();
            return;
        }

        economy = config.getBoolean("economy");
        shoutcaster = config.getBoolean("shoutcaster");
        illusia = config.getBoolean("illusia");
        
        cmEconomy = new CMEconomy(config);
        
    }
    
    public void stopPlugin() {
        this.getPluginLoader().disablePlugin(this);
    }
    
    public void setEconomyStatus(boolean flag) {
        economy = flag;
    }
}
