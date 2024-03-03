package org.example;

import org.example.appConfig.ApplicationConfig;
import org.example.commands.CommandInvoker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        if (args.length == 0) {
            System.err.println("Input file path not provided.");
            return;
        }

        String inputFile = args[0];
        run(inputFile);
    }
    public static void run(String commandLineArgs)
    {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        BufferedReader reader;
        String inputFile = commandLineArgs;
        try
        {
            String line;
            reader = new BufferedReader(new FileReader(inputFile));
            while ((line = reader.readLine()) != null)
            {
                List<String> tokens = Arrays.asList(line.trim().split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
            }
            commandInvoker.executeCommand("MERGE",null);
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}