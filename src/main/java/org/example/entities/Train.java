package org.example.entities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Train implements ITrain {
        private String trainName;
        private final Map<String, Integer> stationDistance;
        private List<Bogie> bogieList;

        public Train(String trainName, Map<String, Integer> stationDistance) {
            this.trainName = trainName;
            this.stationDistance = new HashMap<>(stationDistance);
            this.bogieList = new ArrayList<>();
        }

        public Integer getDistance(String station) {
            return stationDistance.getOrDefault(station, null);
        }

        public void addBogie(Bogie bogie) {
            bogieList.add(bogie);
        }

        public List<Bogie> getAllBogies() {
            return new ArrayList<>(bogieList);
        }

        public String getTrainName() {
            return trainName;
        }

        public boolean hasStation(String station) {
            return stationDistance.containsKey(station);
        }

        public void removeBogie(List<Bogie> bogieList1) {
            bogieList.removeAll(bogieList1);
        }

        public List<String> getAllBogieName() {
            return new ArrayList<>(stationDistance.keySet());
        }

        protected List<Bogie> getBogieList() {
            return bogieList;
        }
}


