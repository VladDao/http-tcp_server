package com.plietnov.task;

import com.epam.rd.plietnov.task9.command.*;
import com.plietnov.task.command.CommandContainer;
import com.plietnov.task.validator.ValidationDigit;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class Manager {

    private static final Logger LOGGER = Logger.getLogger(Manager.class);
    private static final String MAIN_MENU = "main_menu";
    private static final String EXIT = "0";
    private CommandContainer commandContainer;

    public Manager(CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
    }

    public void start() {
        String buffer = StringUtils.EMPTY;
        while (ObjectUtils.notEqual(EXIT, buffer)) {
            LOGGER.info(Util.getResource(MAIN_MENU));
            buffer = Util.readFromConsole();
            if (ValidationDigit.isDigit(buffer)) {
                commandContainer.get(buffer).execute();
            }
        }
    }
}