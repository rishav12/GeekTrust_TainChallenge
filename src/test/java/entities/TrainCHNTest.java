package entities;

import org.example.entities.TrainCHN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Train Chennai Test")
class TrainCHNTest {

    private TrainCHN train;

    @BeforeEach
    void setUp() {
        train = new TrainCHN("TrainCHN");
    }

    @Test
    void testHasStation_ExistingStation_ShouldReturnTrue() {
        assertTrue(train.hasStation("CHN"));
    }

    @Test
    void testHasStation_NonExistingStation_ShouldReturnFalse() {
        assertFalse(train.hasStation("XYZ"));
    }

    @Test
    void testGetDistance_ExistingStation_ShouldReturnCorrectDistance() {
        assertEquals(550, train.getDistance("BLR"));
    }

    @Test
    void testGetDistance_NonExistingStation_ShouldReturnNull() {
        assertNull(train.getDistance("XYZ"));
    }

    @Test
    void testGetAllBogieName_ShouldReturnAllStationNames() {
        HashSet<String> expectedBogies = new HashSet<>(List.of("CHN", "SLM", "BLR", "KRN", "HYB", "NGP", "ITJ", "BPL", "AGA", "NDL"));
        HashSet<String> actualBogies = new HashSet<>(train.getAllBogieName());

        assertEquals(expectedBogies, actualBogies);
    }

}
