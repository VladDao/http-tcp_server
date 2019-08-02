package com.plietnov.task.command;

import com.plietnov.task.Util;
import org.apache.log4j.Logger;

public class NoCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(NoCommand.class);
    private static final String COMMAND_NOT_FOUND = "command_not_found";

    @Override
    public void execute() {
        LOGGER.error(Util.getResource(COMMAND_NOT_FOUND));
    }
}
