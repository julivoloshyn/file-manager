package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.mutable.MutableInt;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Command 'ls' returns a table of files/directories which located in current directory by given
 * parameters: 's, r, w, e' (size, readable, writable, extension). Table can consist only size or
 * size and extension both, etc. If the argument is empty returns a table of file/directories names.
 *
 * Example:
 *
 *     path = "C:\\xamp\\dir"
 *
 *     1. input: ls er
 *        result: | File name | Extension | Readable |
 *                | file.txt  | txt       | true     |
 *                | l         |           | true     |
 *                | nodir     |           | true     |
 *
 *
 *     2. input: ls
 *        result: | File name |
 *                | file.txt  |
 *                | l         |
 *                | nodir     |
 *
 */
public class Ls extends Command {

    public Ls(Context context) {
        super(context);
    }

    /**
     * Checks for an empty arguments and exceptions. Creates an array list that connects headers and body.
     *
     * @param args Arguments which are written after the command.
     */
    @Override
    public String execute(List<String> args) {
        String check = checkForException(args);
        if (check != null) {
            return check;
        }

        args = args.isEmpty() ? args : Arrays.asList(args.get(0).split(""));

        List<List<String>> result = new ArrayList<>();
        result.add(createHeaders(args));
        result.addAll(createBody(args));
        printTable(result, getPreCalculatedStringFormat(result));

        return "";
    }

    /**
     * Checks for exception in case if directory is empty.
     *
     * @param args Arguments which are written after the command.
     * @return null if nothing was thrown or a string which notifies that directory is empty.
     */
    private String checkForException(List<String> args) {
        try {
            context.getCurrentDirectory().listFiles();
            createBody(args);
        } catch (NullPointerException e){
            return "Directory " + context.getCurrentDirectory() + " is empty";
        }
        return null;
    }

    /**
     * Creates headers.
     *
     * @param args Arguments which are written after the command.
     * @return List if headers.
     */
    private List<String> createHeaders(List<String> args) {
        List<String> header = new ArrayList<>();
        header.add("File name");
        for (String flag : args) {
            switch (flag) {
                case "s" -> header.add("Size");
                case "r" -> header.add("Readable");
                case "w" -> header.add("Writable");
                case "e" -> header.add("Extension");
            }
        }
        return header;
    }

    /**
     * Creates columns from rows.
     *
     * @param args Arguments which are written after the command.
     * @return List of rowList.
     */
    private List<List<String>> createBody(List<String> args) {
        List<List<String>> body = new ArrayList<>();
        for (File f : Objects.requireNonNull(context.getCurrentDirectory().listFiles())) {
            body.add(buildRow(args, f));
        }
        return body;
    }

    /**
     * Checks for exception in case if directory is empty.
     *
     * @param args Arguments which are written after the command.
     * @param file File in current directory.
     * @return List of rows.
     */
    private List<String> buildRow(List<String> args, File file) {
        List<String> row = new ArrayList<>();
        row.add(file.getName());
        for (String flag : args) {
            switch (flag) {
                case "s" -> row.add(String.valueOf(FileUtils.sizeOf(file)));
                case "r" -> row.add(String.valueOf(file.canRead()));
                case "w" -> row.add(String.valueOf(file.canWrite()));
                case "e" -> row.add(file.isHidden() ? "" : FilenameUtils.getExtension(file.getName()));
            }
        }
        return row;
    }

    /**
     * Formats columns to tabular view.
     *
     * @param columns Columns.
     * @return String of formatted table.
     */
    public String getPreCalculatedStringFormat(List<List<String>> columns) {
        int columnsCount = columns.get(0).size();
        List<Integer> result = new ArrayList<>();
        for (MutableInt column = new MutableInt(0);
             column.getValue() < columnsCount; column.increment()) {
            result.add(columns.stream().
                    map(row -> row.get(column.getValue())).
                    map(String::length).
                    max(Integer::compare).get());
        }
        return "| " + result.stream().map(v -> "%-" + v + "s").collect(Collectors.joining(" | ")) + " |";
    }

    /**
     * Prints table in correct format.
     *
     * @param result Table rows.
     * @param format Table columns format.
     */
    private void printTable(List<List<String>> result, String format) {
        result.forEach(row -> System.out.printf((format) + "%n", row.toArray()));
    }

}
