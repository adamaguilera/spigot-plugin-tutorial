package commands;

import config.data.TutorialData;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tutorial.util.TutorialLogger;
import tutorial.util.commands.Command;
import tutorial.util.commands.CommandArgument;
import tutorial.util.commands.arguments.StringArgument;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class HelloWorldCommand implements Command {
    @Getter
    final LinkedList<CommandArgument> commandArguments = new LinkedList<>(List.of(
            new StringArgument("helloworld", true)
    ));
    final TutorialLogger logger = new TutorialLogger("HELLOWORLD_COMMAND");

    final String HELLO_WORLD_MESSAGE = "Hello world!";

    /**
     * /helloworld
     * @param arguments represents command arguments being passed in
     */
    public void execute (final CommandSender commandSender, final List<String> arguments, final TutorialData tutorialData) {
        if (commandSender instanceof Player senderPlayer) {
            UUID senderID = senderPlayer.getUniqueId();
            this.logger.message(senderID, HELLO_WORLD_MESSAGE);
        }
    }
}
