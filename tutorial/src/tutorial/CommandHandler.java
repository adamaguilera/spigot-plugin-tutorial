package tutorial;

import commands.ConfigCommand;
import commands.HelloWorldCommand;
import config.data.TutorialData;
import tutorial.util.TutorialLogger;
import tutorial.util.commands.Command;
import tutorial.util.commands.CommandTree;
import org.bukkit.command.CommandSender;

import java.util.LinkedList;
import java.util.List;

public class CommandHandler {
    final TutorialLogger logger = new TutorialLogger("COMMAND_HANDLER", true);

    final CommandTree commandTree = new CommandTree();
    final String RECEIVED_COMMAND = "Handling command of size %d";
    final String COMMAND_FOUND = "Command was found, executing now";
    final String COMMAND_NOT_FOUND = "Command was not found";

    // Add commands here
    public List<Command> commandList = List.of(
            new HelloWorldCommand(),
            new ConfigCommand()
    );

    public CommandHandler () {
        this.commandList.forEach(command -> this.commandTree.insert(command.getCommandArguments(), command));
    }


    // You can change TutorialData to be any argument you need passed down to command functions
    public void handle(final CommandSender sender, final String firstArg, final String[] args, TutorialData tutorialData) {
        LinkedList<String> arguments = new LinkedList<>();
        if (firstArg != null) {
            arguments.add(firstArg);
        }
        arguments.addAll(List.of(args));
        this.logger.debug(String.format(RECEIVED_COMMAND, arguments.size()));
        this.commandTree.findCommand(arguments, 0)
                .ifPresentOrElse(
                        command -> {
                            this.logger.debug(COMMAND_FOUND);
                            command.execute(sender, arguments, tutorialData);
                        },
                        () -> this.logger.debug(COMMAND_NOT_FOUND)
                );
    }
}