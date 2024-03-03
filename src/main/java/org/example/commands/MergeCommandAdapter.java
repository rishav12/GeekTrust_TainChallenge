package org.example.commands;

import java.util.List;

public class MergeCommandAdapter implements ICommand {
    private IMergeCommand mergeCommand;

    public MergeCommandAdapter(IMergeCommand mergeCommand) {
        this.mergeCommand = mergeCommand;
    }

    @Override
    public void execute(List<String> tokens) {
        mergeCommand.execute();
    }
}