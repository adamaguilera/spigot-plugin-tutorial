package tutorial.util.commands;

import config.data.TutorialData;
import org.bukkit.command.CommandSender;

import java.util.LinkedList;
import java.util.List;

public interface Command {
    LinkedList<CommandArgument> getCommandArguments();
    void execute(final CommandSender commandSender, final List<String> arguments, TutorialData tutorialData);
}

