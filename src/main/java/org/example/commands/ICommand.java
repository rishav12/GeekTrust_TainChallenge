package org.example.commands;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);
}

