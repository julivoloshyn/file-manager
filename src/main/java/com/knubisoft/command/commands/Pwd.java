package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.util.List;

/**
 * Command 'pwd' returns a tree current directory.
 *
 * Example:
 *
 *     input: pwd
 *     result: "C:\\xamp\\dir"
 */
public class Pwd extends Command {

    public Pwd(Context context) {
        super(context);
    }

    /**
     * Gets current directory path.
     *
     * @param args Arguments which are written after the command.
     * @return Directory path.
     */
    @Override
    public String execute(List<String> args) {
        return context.getCurrentDirectory().getAbsolutePath();
    }
}
