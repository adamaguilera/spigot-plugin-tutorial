package bankapi.util.commands.arguments;

import bankapi.util.commands.CommandArgument;
import lombok.Getter;

public class IntArgument implements CommandArgument {
    @Getter
    final int priority = 10;
    @Override
    public boolean isValid(String argument) {
        try {
            int value = Integer.parseInt(argument);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public Integer getFromArgument (final String argument) {
        return Integer.parseInt(argument);
    }

    @Override
    public boolean equals (Object o) {
        return o instanceof IntArgument;
    }
}
