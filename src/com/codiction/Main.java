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
import com.codiction.util.Message;
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

    /**
     * Initializes the configuration of the core (config.yml)
     */
    public void initConfiguration() {
        if (!this.getDataFolder().exists()) {
            Message.info(ChatColor.YELLOW + "Configuration file is not found, creating new one...");
            this.saveDefaultConfig();
        } else {
            config = this.getConfig();
            Message.info(ChatColor.BLUE + "Loading configuration...");
        }

        configuredVersion = config.getString("version");

        if (!configuredVersion.equals(this.getDescription().getVersion())) {
            Message.info(ChatColor.RED + "The configuration file cannot be used with this version of CMCore ("
                    + ChatColor.GREEN + this.getDescription().getVersion());
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
