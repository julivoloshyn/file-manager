package com.knubisoft.command;

import com.knubisoft.command.commands.Mkfile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MkfileTest {

    @Test
    public void commandMkfile_Fail(){
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Mkfile mkfile = new Mkfile(context);

        List<String> args = new ArrayList<>();

        assertEquals("Incorrect argument. Enter name to create a file", mkfile.execute(args));
    }

    @Test
    public void commandMkfile_Success() {
        Context context = new Context(null, new File("C:\\xamp"));
        Mkfile mkfile = new Mkfile(context);

        List<String> args = new ArrayList<>();
        args.add("file.txt");

        mkfile.execute(args);
        assertTrue(new File("C:\\xamp\\file.txt").exists());
        assertEquals("", mkfile.execute(args));
    }

    @Test
    public void commandMkfile_FileIsAlreadyExists_Fail() {
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Mkfile mkfile = new Mkfile(context);

        List<String> args = new ArrayList<>();
        args.add("file.txt");

        assertEquals("", mkfile.execute(args));
    }
}
