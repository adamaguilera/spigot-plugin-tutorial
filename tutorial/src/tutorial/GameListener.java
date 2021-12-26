package tutorial;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameListener implements Listener {
    public GameListener () {
        Bukkit.broadcastMessage("GameListener has been initalized!");
    }
}