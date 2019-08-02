package com.plietnov.task.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private Map<String, Command> commands = new HashMap<>();

    public void init(String name, Command command) {
        commands.put(name, command);
    }

    public Command get(String commandName) {
        return commands.getOrDefault(commandName, new NoCommand());
    }
}
