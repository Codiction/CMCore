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
package com.codiction.util;

import com.codiction.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 *
 * @author Admin
 */
public class Message {
    
    static Main main = (Main) Bukkit.getServer().getPluginManager().getPlugin("CMCore");
    
    public static void info(String msg) {
        
        main.getServer().getConsoleSender().sendMessage("<" + main.getName() + "> " + msg + ChatColor.RESET);
        
    }
}
