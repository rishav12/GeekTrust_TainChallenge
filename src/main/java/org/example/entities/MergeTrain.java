package org.example.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTrain extends Train {

    public MergeTrain() {
        super("TRAIN_AB", createStationDistanceMap());
    }
    public MergeTrain(Map<String, Integer> stationDistanceMap) {
        super("TRAIN_AB", stationDistanceMap);
    }
    private static Map<String, Integer> createStationDistanceMap() {
        Map<String, Integer> stationDistance = new HashMap<>();
        stationDistance.put("AGA", 2500);
        stationDistance.put("NDL", 2700);
        stationDistance.put("PTA", 3800);
        stationDistance.put("NJP", 4200);
        stationDistance.put("GHY", 4700);
        return stationDistance;
    }

    public void addAllBogies(List<Bogie> bogies) {
        getBogieList().clear();
        getBogieList().addAll(bogies);
    }

    public int getDistanceFromHyb(String station) {
        Integer stn = getDistance(station);
        Integer d = getDistance("HYB");
        if (stn == null || d == null) {
            return Integer.MAX_VALUE;
        }
        return (stn - d);
    }
}
