package com.plietnov.task.command;

import com.plietnov.task.Init;

public class ExitCommand extends Command {

    private Init init;

    public ExitCommand(Init init) {
        this.init = init;
    }

    @Override
    public void execute() {
        init.destructor();
    }
}
