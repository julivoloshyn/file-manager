package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * Command 'mkdir' creates a new directory.
 *
 * Example:
 *
 *     path = "C:\\xamp\\dir"
 *
 *     input: mkdir newdir
 *     result: "C:\\xamp\\dir\\newdir"
 */
public class Mkdir extends Command {

    public Mkdir(Context context) {
        super(context);
    }

    /**
     * Checks for an empty arguments and a case if a directory name is exists. Creates new directory.
     *
     * @param args Arguments which are written after the command.
     */
    @SneakyThrows
    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Enter name to create a directory";
        } else {
            File file = context.getCurrentDirectory();
            String line = args.get(0);
            File f = new File(file, line);

            if (f.exists()) {
                System.out.println("Directory " + line + " is already exists");
            } else {
                FileUtils.forceMkdir(f);
            }
        }
        return "";
    }
}
