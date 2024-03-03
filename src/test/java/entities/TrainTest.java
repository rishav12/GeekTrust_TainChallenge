package entities;

import org.example.entities.Bogie;
import org.example.entities.Train;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {
    private Train train;

    @BeforeEach
    public void setup() {
        String trainName = "Train123";
        Map<String, Integer> stationDistance = new HashMap<>();
        stationDistance.put("StationA", 100);
        stationDistance.put("StationB", 200);
        stationDistance.put("StationC", 300);

        train = new Train(trainName, stationDistance) {
            public void init() {
            }
        };
    }

    @Test
    public void testGetDistance_ExistingStation_ShouldReturnDistance() {
        assertEquals(Integer.valueOf(100), train.getDistance("StationA"));
        assertEquals(Integer.valueOf(200), train.getDistance("StationB"));
        assertEquals(Integer.valueOf(300), train.getDistance("StationC"));
    }

    @Test
    public void testGetDistance_NonExistingStation_ShouldReturnNull() {
        assertNull(train.getDistance("NonExistingStation"));
    }

    @Test
    public void testAddBogie_ShouldAddBogieToList() {
        Bogie bogie = new Bogie("Bogie123");
        train.addBogie(bogie);
        List<Bogie> bogies = train.getAllBogies();
        assertTrue(bogies.contains(bogie));
    }

    @Test
    public void testGetAllBogies_ShouldReturnAllBogies() {
        Bogie bogie1 = new Bogie("Bogie1");
        Bogie bogie2 = new Bogie("Bogie2");
        train.addBogie(bogie1);
        train.addBogie(bogie2);

        List<Bogie> bogies = train.getAllBogies();
        assertTrue(bogies.contains(bogie1));
        assertTrue(bogies.contains(bogie2));
    }

    @Test
    public void testGetTrainName_ShouldReturnTrainName() {
        assertEquals("Train123", train.getTrainName());
    }

    @Test
    public void testHasStation_ExistingStation_ShouldReturnTrue() {
        assertTrue(train.hasStation("StationA"));
        assertTrue(train.hasStation("StationB"));
        assertTrue(train.hasStation("StationC"));
    }

    @Test
    public void testHasStation_NonExistingStation_ShouldReturnFalse() {
        assertFalse(train.hasStation("NonExistingStation"));
    }

    @Test
    public void testRemoveBogie_ShouldRemoveBogieFromList() {
        Bogie bogie1 = new Bogie("Bogie1");
        Bogie bogie2 = new Bogie("Bogie2");
        train.addBogie(bogie1);
        train.addBogie(bogie2);

        List<Bogie> bogiesToRemove = new ArrayList<>();
        bogiesToRemove.add(bogie1);
        train.removeBogie(bogiesToRemove);

        List<Bogie> bogies = train.getAllBogies();
        assertFalse(bogies.contains(bogie1));
        assertTrue(bogies.contains(bogie2));
    }

    @Test
    public void testGetAllBogieName_ShouldReturnAllStationNames() {
        List<String> expectedStationNames = new ArrayList<>(List.of("StationA", "StationB", "StationC"));
        List<String> actualStationNames = train.getAllBogieName();
        Collections.sort(expectedStationNames);
        Collections.sort(actualStationNames);
        assertEquals(expectedStationNames, actualStationNames);
    }

}
