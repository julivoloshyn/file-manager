package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.io.File;
import java.util.List;

public class Rmr extends Command {

    public Rmr(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Enter file/directory name to delete";
        } else {
            File currentDirectory = context.getCurrentDirectory();
            String fileName = args.get(0);
            File file = new File(currentDirectory, fileName);

            deleteWithRecursion(file);
        }
        return "";
    }

    private boolean deleteWithRecursion(File file) {

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteWithRecursion(f);
            }
        }
        return file.delete();
    }
}
