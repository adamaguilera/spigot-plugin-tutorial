package tutorial.util;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@RequiredArgsConstructor
public class TutorialLogger {
    final static boolean FORCE_HIDE_DEBUG = false;
    final String PLUGIN_NAME = "TUTORIAL";
    final String SERVICE;
    final boolean showDebug;

    public TutorialLogger (final String SERVICE) {
        this.SERVICE = SERVICE;
        this.showDebug = false;
    }

    public void debug(String message) {
        if (showDebug || FORCE_HIDE_DEBUG) {
            Bukkit.getConsoleSender().sendMessage(PLUGIN_NAME + "-" + SERVICE + ": " + message);
        }
    }

    public void console(String message) {
        Bukkit.getConsoleSender().sendMessage(PLUGIN_NAME + "-" + SERVICE + ": " + message);
    }

    public void broadcast(String message) {
        Bukkit.broadcastMessage(message);
    }

    public void message(final UUID playerID, String message) {
        Player player = Bukkit.getPlayer(playerID);
        if (player != null) {
            player.sendMessage(message);
        }
    }
}
