package org.example.entities;

import java.util.List;

public interface ITrain {
    List<String> getAllBogieName();
    void removeBogie(List<Bogie> bogieList);
    boolean hasStation(String station);
    Integer getDistance(String station);
    String getTrainName();
    List<Bogie> getAllBogies();
    void addBogie(Bogie bogie);
}
