package com.knubisoft.command;

import com.knubisoft.command.commands.Rm;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RmTest {

    @Test
    public void commandRm_Fail() {
        Context context = new Context(null, new File("C:\\xamp\\dir\\file.txt"));
        Rm rm = new Rm(context);
        List<String> args = new ArrayList<>();

        assertEquals("Incorrect argument. Enter file name to delete", rm.execute(args));
    }

    @Test
    public void commandRm_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir\\file.txt"));
        Rm rm = new Rm(context);

        List<String> args = new ArrayList<>();
        args.add("file.txt");

        assertEquals("File was successfully deleted", rm.execute(args));
    }
}
