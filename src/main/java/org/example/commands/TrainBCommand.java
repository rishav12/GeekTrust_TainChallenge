package org.example.commands;

import org.example.entities.Bogie;
import org.example.entities.ITrain;
import org.example.entities.TrainTVC;
import org.example.services.ITrainService;

import java.util.List;

public class TrainBCommand implements ITrainCommand {
    ITrainService trainService;
    public TrainBCommand(ITrainService trainService)
    {
        this.trainService = trainService;
    }
    @Override
    public void execute( List<String> tokens) {
        ITrain train = new TrainTVC(tokens.get(0));
        for (int i = 2; i < tokens.size(); i++) {
            Bogie bogie = new Bogie(tokens.get(i));
            train.addBogie(bogie);
        }
        trainService.addTrain(train);
        trainService.getBogiesAfterHyb(train);
        trainService.printTrainSummary();
    }
}
