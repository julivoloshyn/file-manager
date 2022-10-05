package com.knubisoft.command;

import com.knubisoft.command.commands.Cd;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CdTest {

    @Test
    public void CommandCdPreviousDir_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Cd cd = new Cd(context);

        List<String> args = new ArrayList<>();
        args.add("..");
        assertEquals(
                "C:\\xamp",
                cd.execute(args));
    }

    @Test
    public void CommandCdSpecifiedDir_Success() {
        Context context = new Context(null, new File("C:\\xamp"));
        Cd cd = new Cd(context);

        List<String> args = new ArrayList<>();
        args.add("dir");
        assertEquals(
                "C:\\xamp\\dir",
                cd.execute(args));
    }

    @Test
    public void CommandCd_Fail() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Cd cd = new Cd(context);

        List<String> args = new ArrayList<>();
        assertEquals(
                "Incorrect argument. Use `..` to navigate to parent directory or choose right child directory",
                cd.execute(args));

        args.add("k");
        assertEquals(
                "C:\\xamp\\dir",
                cd.execute(args));
    }

}
