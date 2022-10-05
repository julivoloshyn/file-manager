package com.knubisoft.command;

import com.knubisoft.command.commands.Ls;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LsTest {

    @Test
    public void CommandLstree_EmptyArgs_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Ls ls = new Ls(context);

        List<String> args = new ArrayList<>();

        assertEquals("", ls.execute(args));
    }

    @Test
    public void CommandLstree_IncorrectArgs_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Ls ls = new Ls(context);

        List<String> args = new ArrayList<>();
        args.add("fghj");

        assertEquals("", ls.execute(args));
    }

    @Test
    public void CommandLstree_CorrectArgs_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Ls ls = new Ls(context);

        List<String> args = new ArrayList<>();
        args.add("er");

        assertEquals("", ls.execute(args));
    }

    @Test
    public void CommandLstree_CorrectAndIncorrectArgs_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Ls ls = new Ls(context);

        List<String> args = new ArrayList<>();
        args.add("eryt");

        assertEquals("", ls.execute(args));
    }

    @Test
    public void CommandLstree_EmptyDir_Fail() {
        Context context = new Context(null, new File("C:\\xamp\\dir\\o"));
        Ls ls = new Ls(context);

        List<String> args = new ArrayList<>();
        args.add("e");

        assertEquals("Directory " + context.getCurrentDirectory() + " is empty", ls.execute(args));
    }


}
