package com.knubisoft.command;

import com.knubisoft.command.commands.Rmr;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RmrTest {

    @Test
    public void commandRmr_Fail() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Rmr rmr = new Rmr(context);

        List<String> args = new ArrayList<>();

        assertEquals("Incorrect argument. Enter directory name to delete", rmr.execute(args));
    }

    @Test
    public void commandRmr_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir\\l"));
        Rmr rmr = new Rmr(context);

        List<String> args = new ArrayList<>();
        args.add("file.txt");

        assertEquals("Directory was successfully deleted", rmr.execute(args));
    }
}
