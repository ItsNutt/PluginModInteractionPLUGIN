package me.itsnutt.pluginmodinteractionplugin;

import me.itsnutt.pluginmodinteractionmod.Intermediary;
import me.itsnutt.pluginmodinteractionmod.NPCInventoryCommunication;
import me.itsnutt.pluginmodinteractionmod.PluginModInteractionMOD;
import me.itsnutt.pluginmodinteractionmod.RightClickBlockCommunication;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;

public class CommunicationExecutor {

    PluginModInteractionPLUGIN p;

    public CommunicationExecutor(PluginModInteractionPLUGIN plugin){
        p = plugin;
    }

    private final Intermediary intermediary = PluginModInteractionMOD.INSTANCE.getIntermediary();

    protected final BukkitRunnable read = new BukkitRunnable() {
        @Override
        public void run() {
            HashSet<NPCInventoryCommunication> npcToDo = new HashSet<>(intermediary.getNpcInventoryCommunications());
            intermediary.clearNpcInventoryCommunications();

            for (NPCInventoryCommunication NPCInventoryCommunication : npcToDo){
                p.inventories.openInventory(NPCInventoryCommunication.getPlayerUUID(), NPCInventoryCommunication.getNpcName());
                System.out.println("Read!");
            }

            HashSet<RightClickBlockCommunication> blockToDo = new HashSet<>(intermediary.getBlockCommunications());
            intermediary.clearBlockCommunications();

            for (RightClickBlockCommunication Comm : blockToDo){
                Player player = Bukkit.getPlayer(Comm.getPlayerUUID());
                Location location = new Location(player.getWorld(), Comm.getBlockPos().getX(), Comm.getBlockPos().getY(), Comm.getBlockPos().getZ());
                player.sendMessage(ChatColor.DARK_GREEN + "You Just Right Clicked on A " + location.getBlock().getType().name() + "!");
                System.out.println("Message Sent!");
            }

        }
    };
}
