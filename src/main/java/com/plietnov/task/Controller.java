package com.plietnov.task;

import com.plietnov.task.command.CommandContainer;
import com.plietnov.task.command.server.CommandServer;
import com.plietnov.task.server.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private static final Logger LOGGER = Logger.getLogger(Controller.class);
    private static final String REGEXP_GET = "(?<=get\\s)(\\w+)";
    private static final String REGEXP_DIGIT_ARG = "(?<==)(\\d+)";
    private CommandContainer commandContainer;

    public Controller() {
    }

    public Controller(CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
    }

    public void commandProcessTCP(String command, Response response) {
        Matcher regCommand = Pattern.compile(REGEXP_GET).matcher(command);
        Matcher regArg = Pattern.compile(REGEXP_DIGIT_ARG).matcher(command);
        String requestParameter = StringUtils.EMPTY;
        CommandServer commandServer = null;
        if (regCommand.find()) {
            commandServer = (CommandServer) commandContainer.get(regCommand.group());
            LOGGER.info(regCommand.group());
        }
        if (regArg.find()) {
            requestParameter = regArg.group();
            LOGGER.info(regArg.group());
        }
        commandServer.execute(requestParameter, response);
    }

    public void commandProcessHTTP(List<NameValuePair> command, Response response) {
        command.forEach(o -> {
            CommandServer commandServer = (CommandServer) commandContainer.get(o.getName());
            commandServer.execute(o.getValue(), response);
        });
    }

    public void commandHTTPWithoutArg(String parameter, Response response) {
        CommandServer commandServer;
        commandServer = (CommandServer) commandContainer.get(parameter);
        commandServer.execute(parameter, response);
    }
}

