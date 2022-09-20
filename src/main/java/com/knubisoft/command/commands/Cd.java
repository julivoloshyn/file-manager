package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.io.File;
import java.util.List;

public class Cd extends Command {

    public Cd(Context context) {
        super(context);
    }

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
