package org.example.commands;

import java.util.List;

public class TrainCommandAdapter implements ICommand {
        private final ITrainCommand trainCommand;

        public TrainCommandAdapter(ITrainCommand trainCommand) {
            this.trainCommand = trainCommand;
        }

        @Override
        public void execute(List<String> tokens) {
            trainCommand.execute(tokens);
        }
    }

