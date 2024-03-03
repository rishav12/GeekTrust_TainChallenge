package org.example.services;

import org.example.entities.*;

import java.util.*;
import java.util.stream.Collectors;

public class MergeTrainService implements IMergeTrainService {
    private final ITrainService trainService;
    private MergeTrain mergeTrain;
    private Map<String, Integer> distance;
    private Map<String, Integer> countMap;
    private List<Bogie> allTrainBogie;

    public MergeTrainService(ITrainService trainService) {
        countMap = new HashMap<>();
        allTrainBogie = new ArrayList<>();
        mergeTrain = new MergeTrain();
        distance = new HashMap<>();
        this.trainService = trainService;
    }

    public void getAllBogiesAfterHyb() {
        List<ITrain> trains = trainService.getTrainList();
        List<Bogie> bogiList = trains.get(0).getAllBogies();
        allTrainBogie.addAll(bogiList);
        createMapAndCountMap(bogiList, trains.get(0));

        bogiList = trains.get(1).getAllBogies();
        allTrainBogie.addAll(bogiList);
        createMapAndCountMap(bogiList, trains.get(1));

        mergeTwoTrain();
    }

    private void createMapAndCountMap(List<Bogie> bogies, ITrain train) {
        for (Bogie b : bogies) {
            String station = b.getStationName();
            if (countMap.containsKey(station)) {
                int i = countMap.get(station);
                countMap.put(station, i + 1);
            } else {
                countMap.put(station, 1);
            }

            ITrain trainA = new TrainCHN("TempA");
            ITrain trainB = new TrainTVC("TempB");

            if (trainA.hasStation(station)) {
                distance.put(station, trainA.getDistance(station));
            } else {
                distance.put(station, trainB.getDistance(station));
            }
        }
    }

    private void mergeTwoTrain() {
        sortBogies();
    }

    private void sortBogies() {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(distance.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        allTrainBogie.clear();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            int size = countMap.get(entry.getKey());
            for (int i = 0; i < size; i++) {
                Bogie b = new Bogie(entry.getKey());
                allTrainBogie.add(b);
            }
        }
    }

    public List<ITrain> getTrainList() {
        return trainService.getTrainList();
    }
    public void printMergedTrain() {
        System.out.print("DEPARTURE " + mergeTrain.getTrainName() + " ENGINE ENGINE ");
        for (Bogie b : allTrainBogie) {
            if (!b.getStationName().equalsIgnoreCase("HYB"))
                System.out.print(b.getStationName() + " ");
        }
        System.out.print("\n");
    }
}
