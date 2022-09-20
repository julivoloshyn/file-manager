package com.knubisoft.command.commands;

import com.google.common.io.Files;
import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Open extends Command {

    public Open(Context context) {
        super(context);
    }

    @SneakyThrows
    @Override
    public String execute(List<String> args) {

        if (args.isEmpty()) {
            return "Incorrect argument. Enter filename to open it";
        } else {
            String dirName = context.getCurrentDirectory().getAbsolutePath() + "/";
            String line = args.get(0);
            File file = new File(dirName, line);
            String ext = Files.getFileExtension(line);

            if (file.exists()) {
                System.out.println(FileUtils.readFileToString(new File(dirName, line), StandardCharsets.UTF_8));
            } else {
                System.out.println("File does not exists in this directory");
            }
        }
        return "";
    }
}
