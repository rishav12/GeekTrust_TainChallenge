
package org.example.entities;

import java.util.HashMap;
import java.util.Map;



public class TrainCHN extends Train {
       public TrainCHN(String trainName) {
            super(trainName, createStationDistanceMap());
        }

        private static Map<String, Integer> createStationDistanceMap() {
            Map<String, Integer> stationDistance = new HashMap<>();
            stationDistance.put("CHN", 0);
            stationDistance.put("SLM", 350);
            stationDistance.put("BLR", 550);
            stationDistance.put("KRN", 900);
            stationDistance.put("HYB", 1200);
            stationDistance.put("NGP", 1600);
            stationDistance.put("ITJ", 1900);
            stationDistance.put("BPL", 2000);
            stationDistance.put("AGA", 2500);
            stationDistance.put("NDL", 2700);
            return stationDistance;
        }
}


