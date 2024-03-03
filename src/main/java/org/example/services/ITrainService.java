package org.example.services;

import org.example.entities.Bogie;
import org.example.entities.ITrain;

import java.util.List;

public interface ITrainService {
    void addTrain(ITrain t);
    void getBogiesAfterHyb(ITrain train);
    void printTrainSummary();
    void printAllBogie(List<Bogie> bogies);
    List<ITrain> getTrainList();
}
