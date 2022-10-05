package com.knubisoft.command;

import com.knubisoft.command.commands.Pwd;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PwdTest {

    @Test
    public void commandPwdInFile() {
        String pathName = "C:\\xamp\\dir";
        Context context = new Context(null, new File(pathName));
        Pwd pwd = new Pwd(context);

        assertEquals(pathName, pwd.execute(new ArrayList<>()));
        assertNotEquals(pathName + "\\l", pwd.execute(new ArrayList<>()));
    }

    @Test
    public void commandPwdInDir() {
        String pathName = "C:\\xamp\\dir\\file.txt";
        String wrongPathName = "C:\\xamp\\dir";
        Context context = new Context(null, new File(pathName));
        Pwd pwd = new Pwd(context);

        assertEquals(pathName, pwd.execute(new ArrayList<>()));
        assertNotEquals(wrongPathName, pwd.execute(new ArrayList<>()));
    }
}
