package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class Mkdir extends Command {

    public Mkdir(Context context) {
        super(context);
    }

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
