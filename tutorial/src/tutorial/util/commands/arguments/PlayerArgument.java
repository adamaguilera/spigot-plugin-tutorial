package bankapi.util.commands.arguments;

import bankapi.util.commands.CommandArgument;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerArgument implements CommandArgument {
    @Getter
    final int priority = 1;

    @Override
    public boolean isValid(String argument) {
        return Bukkit.getPlayer(argument) != null;
    }

    public Player getFromArgument (final String argument) {
        return Bukkit.getPlayer(argument);
    }

    @Override
    public boolean equals (Object o) {
        return o instanceof PlayerArgument;
    }
}
