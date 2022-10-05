package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.util.List;
import java.util.Map;

/**
 * Command 'help' displays in console a list of available commands.
 */
public class Help extends Command {

    public Help(Context context) {
        super(context);
    }

    /**
     * Processes the map of commands and returns it in string
     *
     * @param args Arguments which are written after the command.
     * @return Result list.
     */
    @Override
    public String execute(List<String> args) {
        Map<String, Command> commands = context.getCommandMap();

        StringBuilder result = new StringBuilder("Available commands:\n");
        if (commands != null) {
            for (String each: commands.keySet()){
                result.append(each).append("\n");
            }
        }
        return result.toString();
    }
}
