package entities;

import org.example.entities.Bogie;
import org.example.entities.MergeTrain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTrainTest {
    private MergeTrain mergeTrain;

    @BeforeEach
    public void setup() {
        Map<String, Integer> stationDistanceMap = new HashMap<>();
        stationDistanceMap.put("AGA", 2500);
        stationDistanceMap.put("NDL", 2700);
        stationDistanceMap.put("PTA", 3800);
        stationDistanceMap.put("NJP", 4200);
        stationDistanceMap.put("GHY", 4700);

        mergeTrain = new MergeTrain(stationDistanceMap);
    }


    @Test
    public void testRemoveBogie() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Station1"));
        bogies.add(new Bogie("Station2"));
        bogies.add(new Bogie("Station3"));

        mergeTrain.addAllBogies(bogies);

        List<Bogie> bogiesToRemove = new ArrayList<>();
        bogiesToRemove.add(new Bogie("Station1"));
        bogiesToRemove.add(new Bogie("Station3"));

        mergeTrain.removeBogie(bogiesToRemove);

        assertEquals(1, mergeTrain.getAllBogies().size());
    }

    @Test
    public void testAddAllBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Station1"));
        bogies.add(new Bogie("Station2"));
        bogies.add(new Bogie("Station3"));

        mergeTrain.addAllBogies(bogies);

        assertEquals(3, mergeTrain.getAllBogies().size());
    }


}
