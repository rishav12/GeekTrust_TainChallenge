package org.example.services;

import org.example.entities.Bogie;
import org.example.entities.ITrain;
import org.example.entities.MergeTrain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrainService implements ITrainService {

    private List<ITrain> trains;

    public TrainService() {
        trains = new ArrayList<>();
    }

    public void addTrain(ITrain t) {
        trains.add(t);
    }

    public void printTrainSummary() {
        for (ITrain train : trains) {
            String trainName = train.getTrainName();
            System.out.print("ARRIVAL " + trainName);
            printAllBogie(train.getAllBogies());
            System.out.print("\n");
        }
    }

    public void printAllBogie(List<Bogie> bogies) {
        System.out.print(" ENGINE ");
        for (Bogie bogie : bogies) {
            System.out.print(bogie.getStationName() + " ");
        }
    }

    public void getBogiesAfterHyb(ITrain train) {
        List<Bogie> bogies = train.getAllBogies();
        List<Bogie> newBogies = new ArrayList<>();

        int hybDistance = train.getDistance("HYB");

        for (Bogie bogie : bogies) {
            String station = bogie.getStationName();
            Integer stationDistance = train.getDistance(station) ;
            if (stationDistance == null)
                stationDistance = new MergeTrain().getDistance(station);
            if (stationDistance < hybDistance) {
                newBogies.add(bogie);
            }
        }
        train.removeBogie(newBogies);
    }


    public List<ITrain> getTrainList() {
        return trains;
    }
}
