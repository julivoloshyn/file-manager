package com.knubisoft.command;

import com.knubisoft.command.commands.Mkdir;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MkdirTest {

    @Test
    public void commandMkdir_Fail(){
        Context context = new Context(null, new File("C:\\xamp\\dir"));
        Mkdir mkdir = new Mkdir(context);

        List<String> args = new ArrayList<>();

        assertEquals("Incorrect argument. Enter name to create a directory", mkdir.execute(args));
    }

    @Test
    public void commandMkdir_Success() {
        Context context = new Context(null, new File("C:\\xamp"));
        Mkdir mkdir = new Mkdir(context);

        List<String> args = new ArrayList<>();
        args.add("directory");

        mkdir.execute(args);
        assertTrue(new File("C:\\xamp\\directory").exists());
    }

    @Test
    public void commandMkdir_FileIsAlreadyExists_Fail() {
        Context context = new Context(null, new File("C:\\xamp"));
        Mkdir mkdir = new Mkdir(context);

        List<String> args = new ArrayList<>();
        args.add("dir");

        assertEquals("", mkdir.execute(args));
    }
}
