package bankapi.util.commands;

public interface CommandArgument {
    boolean isValid (final String argument);

    /**
     * Used to determine which command to execute if multiple command arguments are true where
     * the smallest number takes priority
     * @return priotiy of this command argument
     */
    int getPriority();
}
