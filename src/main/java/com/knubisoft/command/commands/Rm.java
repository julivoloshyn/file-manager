package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Rm extends Command {

    public Rm(Context context) {
        super(context);
    }

    @SneakyThrows
    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Enter file/directory name to delete";
        } else {
            File file = context.getCurrentDirectory();
            String line = args.get(0);
            File current = new File(file, line);

            Files.deleteIfExists(
                    Paths.get(current.getPath()));
        }
        return "";
    }
}
