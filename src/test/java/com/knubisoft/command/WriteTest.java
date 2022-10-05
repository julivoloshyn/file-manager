package com.knubisoft.command;

import com.knubisoft.command.commands.Write;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriteTest {

    @Test
    public void commandWrite_UnexpectedExtension_Fail() {
        Context context = new Context(null, new File("C:\\xamp\\dir\\file.docx"));
        Write rm = new Write(context);
        List<String> args = new ArrayList<>();

        assertEquals("Go to .txt file", rm.execute(args));
    }

    @Test
    public void commandWrite_Success() {
        Context context = new Context(null, new File("C:\\xamp\\dir\\file.txt"));
        Write write = new Write(context);
        List<String> args = new ArrayList<>();

        String input = "hola";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("", write.execute(args));
    }
}
