package me.itsnutt.pluginmodinteractionplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class PluginModInteractionPLUGIN extends JavaPlugin {

    public final Inventories inventories = new Inventories();

    private final CommunicationExecutor communicationExecutor = new CommunicationExecutor(this);

    @Override
    public void onEnable() {
        communicationExecutor.read.runTaskTimer(this, 0, 5);
    }

    @Override
    public void onDisable() {
    }
}
