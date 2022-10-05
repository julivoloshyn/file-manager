package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.io.File;
import java.util.List;

/**
 * Command 'cd' with argument '..' goes from current directory/file to a parent directory.
 * If argument is file- or directory name, program finds child directory/file and goes into it.
 *
 * Example:
 *
 *     path = "C:\\xamp\\dir"
 *
 *     1. input: cd ..
 *        result: "C:\\xamp"
 *
 *     2. input: cd l
 *        result: "C:\\xamp\\dir\\l"
 */
public class Cd extends Command {

    public Cd(Context context) {
        super(context);
    }

    /**
     * Checks for an empty arguments and gets parameters for method chooseDirection(direction, currentDirectory).
     *
     * @param args Arguments which are written after the command.
     * @return Current directory.
     */
    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Use `..` to navigate to parent directory or choose right child directory";
        } else {
            String direction = args.get(0);
            File currentDirectory = context.getCurrentDirectory();

            chooseDirection(direction, currentDirectory);
        }
        return context.getCurrentDirectory().getAbsolutePath();
    }

    /**
     * Chooses a direction from the argument by checking parameters.
     *
     * @param direction A name of child directory/file or '..'.
     * @param currentDirectory Currents directory.
     */
    private void chooseDirection(String direction, File currentDirectory) {

        if (direction.equals("..")) {
            context.setCurrentDirectory(currentDirectory.getParentFile());
        } else {
            File child = new File(currentDirectory, direction);

            if (!child.exists()) {
                System.out.println("Child directory " + direction + " does not exist");
            } else {
                context.setCurrentDirectory(child);
            }
        }
    }
}
