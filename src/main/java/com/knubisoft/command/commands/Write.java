package com.knubisoft.command.commands;

import com.google.common.io.Files;
import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Write extends Command {

    public Write(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {

        String ext = Files.getFileExtension(context.getCurrentDirectory().getAbsolutePath());

        if(ext.equals("txt")) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter text to insert: ");
            String line = scanner.nextLine();

            writeToFile(line);
        } else{
            return "Go to .txt file";
        }

        return "";
    }

    private void writeToFile(String line) {
        try {
            FileWriter fw = new FileWriter(context.getCurrentDirectory(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("Error during writing");
        }
    }
}
