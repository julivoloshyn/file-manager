package com.knubisoft.command.commands;

import com.google.common.io.Files;
import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.List;

public class LsAll extends Command {

    public LsAll(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        File file = context.getCurrentDirectory();
        File[] allFiles = file.listFiles();

        String leftAlignFormat = "| %-17s | %-13s | %-5s | %-5s | %-9s |%n";

        System.out.format("+-------------------+---------------+-------+-------+-----------+%n");
        System.out.format("| File name         | size          |   r   |   w   | extension |%n");
        System.out.format("+-------------------+---------------+-------+-------+-----------+%n");

        for (File each: allFiles) {
            System.out.format(leftAlignFormat,
                    FilenameUtils.getBaseName(each.getName()),
                    each.getUsableSpace(),
                    each.canRead(),
                    each.canWrite(),
                    FilenameUtils.getExtension(each.getName()));
        }
        System.out.format("+-------------------+---------------+-------+-------+-----------+%n");

        return "";
    }

}
