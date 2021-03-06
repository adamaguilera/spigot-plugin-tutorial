package tutorial.util.commands.arguments;

import tutorial.util.TutorialLogger;
import tutorial.util.commands.CommandArgument;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@RequiredArgsConstructor
public class StringArgument implements CommandArgument {
    final TutorialLogger logger = new TutorialLogger("STRING_ARGUMENT");
    final String CHECKING_VALIDITY_FOR_ARGUMENT = "Checking if passed argument %s matches string argument %s";
    final String argument;
    final boolean ignoreCaps;
    @Getter
    final int priority = 0;

    public String getArgument (final String argument) {
        return ignoreCaps ? argument.toLowerCase(Locale.ROOT) : this.argument;
    }

    @Override
    public boolean isValid(String argument) {
        if (argument == null) {
            return false;
        }
        this.logger.debug(String.format(CHECKING_VALIDITY_FOR_ARGUMENT, argument, this.argument));
        return this.argument.equals(this.getArgument(argument));
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof StringArgument stringArgument) {
            return this.argument.equals(stringArgument.argument) && this.ignoreCaps == stringArgument.ignoreCaps;
        }
        return false;
    }
}
