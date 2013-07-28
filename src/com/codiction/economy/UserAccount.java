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

package com.codiction.economy;

import com.codiction.Main;
import org.bukkit.Bukkit;

/**
 *
 * @author Codiction
 */
public class UserAccount {

    private transient Main main = (Main) Bukkit.getPluginManager().getPlugin("CMCore");
    private String ownerUsername;
    
    private double accountBalance = 0.0;
    
    public UserAccount() {
        
    }
    
    /**
     * Sets the owner of this bank account
     * @param name The username of the owner
     */
    public void setOwner(String name) {
        ownerUsername = name;
    }
    
    public double getBalance() {
        return accountBalance;
    }
}
