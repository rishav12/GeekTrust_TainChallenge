package org.example.entities;

import java.util.HashMap;
import java.util.Map;

public class TrainTVC extends Train {
    public TrainTVC(String trainName) {
        super(trainName, createStationDistanceMap());
    }

    private static Map<String, Integer> createStationDistanceMap() {
        Map<String, Integer> stationDistance = new HashMap<>();
        stationDistance.put("TVC", 0);
        stationDistance.put("SRR", 300);
        stationDistance.put("MAQ", 600);
        stationDistance.put("MAO", 1000);
        stationDistance.put("PNE", 1400);
        stationDistance.put("HYB", 2000);
        stationDistance.put("NGP", 2400);
        stationDistance.put("ITJ", 2700);
        stationDistance.put("BPL", 2800);
        stationDistance.put("PTA", 3800);
        stationDistance.put("NJP", 4200);
        stationDistance.put("GHY", 4700);
        return stationDistance;
    }

    public int getDistanceFromHyb(String station) {
        int stn = getDistance(station);
        int d = getDistance("HYB");
        return Math.abs(stn - d);
    }
}
