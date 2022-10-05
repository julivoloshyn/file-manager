package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.io.File;
import java.util.List;

/**
 * Command 'rmr' deletes a directory recursively.
 *
 * Example:
 *
 *     input: rm dir
 *     result: Directory was successfully deleted.
 */
public class Rmr extends Command {

    public Rmr(Context context) {
        super(context);
    }

    /**
     * Checks for correct input and then calls recursive method to delete directory.
     *
     * @param args Arguments which are written after the command.
     * @return String.
     */
    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Enter directory name to delete";
        } else {
            File currentDirectory = context.getCurrentDirectory();
            String fileName = args.get(0);
            File file = new File(currentDirectory, fileName);

            deleteWithRecursion(file);
        }
        return "Directory was successfully deleted";
    }

    /**
     * Deletes directory using recursion.
     *
     * @param file File.
     * @return true in case if it was deleted.
     */
    private boolean deleteWithRecursion(File file) {

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteWithRecursion(f);
            }
        }
        return file.delete();
    }
}
