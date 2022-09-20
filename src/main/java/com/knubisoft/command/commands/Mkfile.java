package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class Mkfile extends Command {

    public Mkfile(Context context) {
        super(context);
    }

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
