package bankapi.util.commands;

import bankapi.util.BankLogger;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CommandTree {
    final BankLogger logger = BankLogger.builder()
            .SERVICE("COMMAND_TREE")
            .showDebug(true)
            .build();
    final String MAX_DEPTH_COMMAND_SEARCH_RETURNING_COMMAND = "Index %d >= %d argument size, returning command here";
    final String SEARCHING_FOR_COMMAND_AT_INDEX = "Searching for command at index %d on argument %s";
    final String FOUND_VALID_MATCHING_ARGUMENTS = "Found %d valid matching arguments";
    final HashMap<CommandArgument, CommandTree> commandTrees = new HashMap<>();
    @Nullable
    Command command;

    public Command insert(final LinkedList<CommandArgument> arguments, final Command command) {
        if (arguments.peek() != null) {
            CommandArgument next = arguments.pop();
            commandTrees.putIfAbsent(next, new CommandTree());
            return commandTrees.get(next).insert(arguments, command);
        } else {
            this.command = command;
            return this.command;
        }
    }

    public Optional<Command> findCommand(final List<String> arguments, final int index) {
        // if this isn't the head, a command matches the path or reached max depth
        if ((index != 0 && this.command != null) || arguments.size() <= index) {
            this.logger.debug(String.format(MAX_DEPTH_COMMAND_SEARCH_RETURNING_COMMAND, index, arguments.size()));
            return Optional.ofNullable(this.command);
        } else {
            this.logger.debug(String.format(SEARCHING_FOR_COMMAND_AT_INDEX, index, arguments.get(index)));
            // find all matching arguments at this tree and sort them by priority
            List<CommandArgument> sortedMatchingArguments = commandTrees.keySet().stream()
                    .filter(commandArgument -> commandArgument.isValid(arguments.get(index)))
                    .sorted().toList();
            this.logger.debug(String.format(FOUND_VALID_MATCHING_ARGUMENTS, sortedMatchingArguments.size()));
            // by priority, return command if tree finds a command
            for (CommandArgument commandArgument : sortedMatchingArguments) {
                Optional<Command> foundCommand =
                        this.commandTrees.get(commandArgument).findCommand(arguments, index + 1);
                if (foundCommand.isPresent()) {
                    return foundCommand;
                }
            }
        }
        return Optional.empty();
    }
}