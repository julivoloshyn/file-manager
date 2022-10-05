package com.knubisoft.command;

import com.knubisoft.command.commands.LsTree;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LstreeTest {

    @Test
    public void CommandLstree_EmptyArgs_Fail() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        LsTree lsTree = new LsTree(context);

        List<String> args = new ArrayList<>();

        assertEquals(
                "You need to enter a depth",
                lsTree.execute(args));
    }

    @Test
    public void CommandLstree_NegativeNum_Fail1() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        LsTree lsTree = new LsTree(context);

        List<String> args = new ArrayList<>();
        args.add("-1");

        assertEquals(
                "Depth can not be negative",
                lsTree.execute(args));
    }

    @Test
    public void CommandLstree_NegativeNum_Fail2() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        LsTree lsTree = new LsTree(context);

        List<String> args = new ArrayList<>();
        args.add("0");

        assertEquals(
                "Depth can not be negative",
                lsTree.execute(args));
    }

    @Test
    public void CommandLstree_NotANumber_Fail1() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        LsTree lsTree = new LsTree(context);

        List<String> args = new ArrayList<>();
        args.add("hello");

        assertEquals(
                "Enter a number",
                lsTree.execute(args));
    }

    @Test
    public void CommandLstree_NotANumber_Fail2() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        LsTree lsTree = new LsTree(context);

        List<String> args = new ArrayList<>();
        args.add("6-32j");

        assertEquals(
                "Enter a number",
                lsTree.execute(args));
    }

}
