package tutorial;

import config.TutorialConfig;
import config.data.TutorialData;
import org.jetbrains.annotations.NotNull;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import tutorial.util.TutorialLogger;

import java.io.File;

public class Main extends JavaPlugin {

    final String ON_ENABLE = "Tutorial Plugin has been enabled!";
    final String ON_DISABLE = "Tutorial Plugin has been disabled!";
    final TutorialLogger logger = new TutorialLogger("MAIN", true);
    final String TUTORIAL_CONFIG_FOLDER = "./plugins/Tutorial/";
    final String CREATED_TUTORIAL_CONFIG_FOLDER = "Created Tutorial config folder";
    GameListener gameListener = new GameListener();
    CommandHandler commandHandler = new CommandHandler();
    TutorialConfig tutorialConfig = new TutorialConfig();
    TutorialData tutorialData;

    @Override
    public void onEnable () {
        // load from config
        this.generateConfigFolderIfNotPresent();
        this.tutorialData = tutorialConfig.load();
        this.getServer().getPluginManager().registerEvents(gameListener, this);
        this.logger.console(ON_ENABLE);
    }

    @Override
    public void onDisable () {
        this.tutorialConfig.save(this.tutorialData);
        this.logger.console(ON_DISABLE);
    }


    @Override
    public boolean onCommand (@NotNull CommandSender sender, Command command,
                              @NotNull String label, String[] args) {
        this.commandHandler.handle(sender, command.getName(), args, tutorialData);
        return true;
    }

    public void generateConfigFolderIfNotPresent () {
        File bankAPIFolder =  new File(TUTORIAL_CONFIG_FOLDER);
        if (bankAPIFolder.mkdirs()) {
            this.logger.debug(CREATED_TUTORIAL_CONFIG_FOLDER);
        }
    }
}