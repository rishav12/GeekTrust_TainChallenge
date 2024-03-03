package org.example.commands;

import org.example.entities.Bogie;
import org.example.entities.ITrain;
import org.example.entities.TrainCHN;
import org.example.services.ITrainService;

import java.util.List;


public class TrainACommand implements ITrainCommand {
    ITrainService trainService;
    public TrainACommand(ITrainService trainService)
    {
        this.trainService = trainService;
    }
    @Override
    public void execute(List<String> tokens) {
        ITrain train = new TrainCHN(tokens.get(0));
        for (int i = 2; i < tokens.size(); i++) {
            Bogie bogie = new Bogie(tokens.get(i));
            train.addBogie(bogie);
        }
        trainService.addTrain(train);
        trainService.getBogiesAfterHyb(train);
    }
}
