package entities;

import org.example.entities.TrainTVC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



@DisplayName("Train Trivandrum Test")
public class TrainTVCTest {

    private TrainTVC trainTVC;

    @BeforeEach
    public void setup() {
        trainTVC = new TrainTVC("TRAIN_TVC");
    }

    @Test
    public void testGetDistanceFromHyb_StationWithinHyb() {
        int distance = trainTVC.getDistanceFromHyb("MAQ");
        assertEquals(1400, distance);
    }

    @Test
    public void testGetDistanceFromHyb_StationAfterHyb() {
        int distance = trainTVC.getDistanceFromHyb("GHY");
        assertEquals(2700, distance);
    }

    @Test
    public void testGetDistanceFromHyb_StationBeforeHyb() {
        int distance = trainTVC.getDistanceFromHyb("SRR");
        assertEquals(1700, distance);
    }

    @Test
    public void testGetDistanceFromHyb_HybItself() {
        int distance = trainTVC.getDistanceFromHyb("HYB");
        assertEquals(0, distance);
    }
}
