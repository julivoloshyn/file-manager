package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

/**
 * Command 'mkfile' creates a new file.
 *
 * Example:
 *
 *     path = "C:\\xamp\\dir"
 *
 *     input: mkfile file.txt
 *     result: "C:\\xamp\\dir\\file.txt"
 */

public class Mkfile extends Command {

    public Mkfile(Context context) {
        super(context);
    }

    /**
     * Checks for an empty arguments and a case if a file name is exists. Creates new file.
     *
     * @param args Arguments which are written after the command.
     */
    @SneakyThrows
    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Enter name to create a file";
        } else {
            File currentDirectory = context.getCurrentDirectory();
            String fileName = args.get(0);
            File file = new File(currentDirectory, fileName);

            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("File " + fileName + " is already exists");
            }
        }
        return "";
    }
}
