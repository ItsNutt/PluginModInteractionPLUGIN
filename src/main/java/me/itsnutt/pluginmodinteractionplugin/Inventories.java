package me.itsnutt.pluginmodinteractionplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.UUID;

public class Inventories {

    private final HashMap<String, Inventory> inventories = new HashMap<>();

    public void openInventory(UUID uuid, String label){
        if (!inventories.containsKey(label)){
            inventories.put(label, Bukkit.createInventory(null, 27, ChatColor.DARK_BLUE + label));
            System.out.println("Created Inventory for NPC " + label);
        }
        Bukkit.getPlayer(uuid).openInventory(inventories.get(label));
        System.out.println("Actually Opened The Inventory");
    }
}
