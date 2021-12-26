package tutorial;

import tutorial.GameListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    final String ON_ENABLE = "Tutorial Plugin has been enabled!";
    final String ON_DISABLE = "Tutorial Plugin has been disabled!";
    final String COMMAND_RECEIVED = "A command has been received!";

    GameListener gameListener;

    @Override
    public void onEnable () {
        this.gameListener = new GameListener();
        this.getServer().getPluginManager().registerEvents(gameListener, this);
        Bukkit.broadcastMessage(ON_ENABLE);
    }

    @Override
    public void onDisable () {
        Bukkit.broadcastMessage(ON_DISABLE);
    }


    @Override
    public boolean onCommand (CommandSender sender,Command command,
                              String label, String[] args) {
        Bukkit.broadcastMessage(COMMAND_RECEIVED);
        return true;
    }
}