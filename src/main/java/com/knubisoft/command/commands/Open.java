package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Command 'open' opens for reading chosen file.
 *
 * Example:
 *
 *     path = "C:\\xamp\\dir"
 *
 *     input: open file.txt
 *     result: "hello"
 */
public class Open extends Command {

    public Open(Context context) {
        super(context);
    }

    /**
     * Checks for an empty arguments and a case if a directory name is not exists. Prints a text from file.
     *
     * @param args Arguments which are written after the command.
     */
    @SneakyThrows
    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Enter filename to open it";
        } else {
            String dirName = context.getCurrentDirectory().getAbsolutePath() + "/";
            String line = args.get(0);
            File file = new File(dirName, line);

            if (file.exists()) {
                System.out.println(FileUtils.readFileToString(new File(dirName, line), StandardCharsets.UTF_8));
            } else {
                return "File does not exists in this directory";
            }
        }
        return "";
    }
}
