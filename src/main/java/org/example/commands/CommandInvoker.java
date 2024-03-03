package org.example.commands;

import org.example.exceptions.NoSuchCommandException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker {
    private final Map<String, ICommand> commandMap = new HashMap<>();

    public void register(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }

    public ICommand get(String commandName) {

        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName, List<String> tokens){

        ICommand command = get(commandName);
        if (command == null) {
            // Handle Exception
            //System.out.println("NO_SUCH_COMMAND");
            //System.exit(0);
            throw new NoSuchCommandException("NO_SUCH_COMMAND");
        }
        command.execute(tokens);
    }
}

