package com.plietnov.task.command;

import com.plietnov.task.Util;
import org.apache.log4j.Logger;

public class ChangeLanguageCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(ChangeLanguageCommand.class);
    private static final String LANGUAGE_MENU = "language_menu";

    @Override
    public void execute() {
        LOGGER.info(Util.getResource(LANGUAGE_MENU));
        Util.setLocale(Util.readFromConsole());
    }
}

