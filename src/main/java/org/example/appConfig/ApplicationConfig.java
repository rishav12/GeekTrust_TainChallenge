package org.example.appConfig;

import org.example.commands.*;
import org.example.services.IMergeTrainService;
import org.example.services.ITrainService;
import org.example.services.MergeTrainService;
import org.example.services.TrainService;

public class ApplicationConfig {
    private final ITrainService trainService = new TrainService();
    private final IMergeTrainService mergeTrainService = new MergeTrainService(trainService);

    private final ITrainCommand trainACommand = new TrainACommand(trainService);
    private final ITrainCommand trainBCommand = new TrainBCommand(trainService);
    private final IMergeCommand mergeCommand = new MergeCommand(mergeTrainService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public ApplicationConfig() {
        commandInvoker.register("TRAIN_A", new TrainCommandAdapter(trainACommand));
        commandInvoker.register("TRAIN_B", new TrainCommandAdapter(trainBCommand));
        commandInvoker.register("MERGE", new MergeCommandAdapter(mergeCommand));
    }

    public CommandInvoker getCommandInvoker() {
        return commandInvoker;
    }
}
