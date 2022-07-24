package tutorial;

import org.bukkit.event.Listener;
import tutorial.util.TutorialLogger;

public class GameListener implements Listener {
    TutorialLogger logger = new TutorialLogger("GAME_LISTENER");
    final String GAME_LISTENER_INTIALIZED = "GameListener has been initialized!";

    public GameListener () {
        this.logger.console(GAME_LISTENER_INTIALIZED);
    }
}