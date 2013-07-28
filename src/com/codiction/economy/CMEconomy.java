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
import com.codiction.util.CMXStream;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Codiction
 */
public class CMEconomy {

    private FileConfiguration config;

    private String currencySign;
    private boolean increaseOnlineUserBalance;

    private String accountFilePath;

    private final Main main = (Main) Bukkit.getServer().getPluginManager().getPlugin("CMCore");

    public CMEconomy(FileConfiguration config) {
        this.config = config;

        if (!initEconomy()) {
            main.getLogger().severe(ChatColor.RED + "Economy failed to load! Disabling economy component.");
            config.set("economy", false);
        } else {
            main.info("&aEconomy is online!&r");
            testAccountCreation("Aristocracy101");
        }
    }

    /**
     * Initializes the Economy component
     *
     * @return true if successful, false if failed
     */
    public boolean initEconomy() {
        accountFilePath = main.getDataFolder().getPath() + "\\Economy\\Accounts\\";
        File tempFileVar = new File(accountFilePath);
        if (!tempFileVar.exists()) {
            tempFileVar.mkdirs();

        }

        
        return true;
    }

    /**
     * debug: test file creation
     *
     * @param name
     */
    private void testAccountCreation(String name) {
        
        if (hasToCreateAccount(name)) {
            createAccount(name);
        } else {
            UserAccount acc = (UserAccount) loadAccount(name);
            System.out.println(acc.getBalance());
        }
    }

    /**
     * Checks in the data folder if the user account file exists or not
     *
     * @param name The name of the user
     * @return true if it exists, false if it doesn't
     */
    private boolean hasToCreateAccount(String name) {
        File temp = new File(accountFilePath + name.toLowerCase() + ".xml");
        return !temp.exists();
    }

    /**
     * Creates the user account file (.xml)
     *
     * @param name The name of the user
     */
    private void createAccount(String name) {
        File temp = new File(accountFilePath + name.toLowerCase() + ".xml");
        UserAccount ua = new UserAccount();
        ua.setOwner(name);

        CMXStream.writeData(CMXStream.getXStream().toXML(ua), temp);

    }
    
    private Object loadAccount(String name) {
        File temp = new File(accountFilePath + name.toLowerCase() + ".xml");
        return CMXStream.getXStream().fromXML(temp);
    }
}
