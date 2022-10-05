package com.knubisoft.command.commands;

import com.google.common.io.Files;
import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Command 'write' writes an input from console to txt file.
 *
 * Example:
 *
 *     path = "C:\\xamp\\dir.txt"
 *
 *     input: "hello"
 *     result: "hello"
 */
public class Write extends Command {

    public Write(Context context) {
        super(context);
    }

    /**
     * Checks for an empty arguments and for case if a file is not .txt.
     * Gets text from console and gives it to method writeToFile(String line).
     *
     * @param args Arguments which are written after the command.
     */
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

    /**
     * Writes text from console to file.
     *
     * @param line text from console.
     */
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
