package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.io.File;
import java.util.List;

/**
 * Command 'lstree' returns a tree of files/directories. A depth of the three is given from console.
 *
 * Example:
 *
 *     path = "C:\\xamp\\dir"
 *
 *     input: lstree 2
 *     result: +--dir/
 *             |  +--file.docx
 *             |  +--file.txt
 *             |  +--l/
 *             |  |  +--g
 *             |  +--o
 *             |  +--r
 */
public class LsTree extends Command {

    public LsTree(Context context) {
        super(context);
    }

    /**
     * Checks for an empty arguments and exceptions. Creates a string of tree.
     *
     * @param args Arguments which are written after the command.
     * @return String of tree.
     */
    @Override
    public String execute(List<String> args) {
        if(args.isEmpty()){
            return "You need to enter a depth";
        }

        String check = intCheck(args);
        if (check != null) {
            return check;
        }

        File directory = context.getCurrentDirectory();
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(args, directory, indent, sb, 0);
        return sb.toString();
    }

    /**
     * Checks for a correct format number.
     *
     * @param args Arguments which are written after the command.
     * @return null if everything is correct.
     */
    private String intCheck(List<String> args) {

        try {
            Integer.parseInt(args.get(0));
        } catch (NumberFormatException e){
            return "Enter a number";
        }

        if(Integer.parseInt(args.get(0)) <= 0){
            return "Depth can not be negative";
        }
        return null;
    }

    /**
     * Recursively builds a tree by given depth.
     *
     * @param args Arguments which are written after the command.
     * @param directory file.
     * @param indent Indent.
     * @param sb For building branch .
     * @param depth given depth.
     */
    private void printDirectoryTree(List<String> args, File directory, int indent,
                                           StringBuilder sb, int depth) {
        int askedDepth = Integer.parseInt(args.get(0));
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(directory.getName());
        sb.append("/");
        sb.append("\n");
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                if(++depth<askedDepth) {
                    printDirectoryTree(args, file, indent + 1, sb, depth);
                }
                else {
                    printFile(file, indent + 1, sb);
                }
            } else {
                printFile(file, indent + 1, sb);
            }
        }

    }

    /**
     * In case of finding new file/directory creates an '+--' indent and adds file name.
     *
     * @param file File to get file name.
     * @param indent Indent.
     * @param sb For building branch.
     */
    private void printFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(file.getName());
        sb.append("\n");
    }

    /**
     * Prints indent '|'.
     *
     * @param indent Indent.
     * @return Indent string.
     */
    private String getIndentString(int indent) {
        return "|  ".repeat(Math.max(0, indent));
    }

}
