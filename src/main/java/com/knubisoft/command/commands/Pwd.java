package com.knubisoft.command.commands;

import com.knubisoft.command.Command;
import com.knubisoft.command.Context;

import java.util.List;

public class Pwd extends Command {

    public Pwd(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        return context.getCurrentDirectory().getAbsolutePath();
    }
}
