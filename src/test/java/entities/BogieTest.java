package entities;

import org.example.entities.Bogie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BogieTest")
public class BogieTest {

    @Test
    @DisplayName("Should return station name")
    public void getStation_shouldReturnStation()
    {
        Bogie b = new Bogie("HYB");
        Assertions.assertEquals("HYB", b.getStationName());
    }

    @Test
    @DisplayName("Should return station name Empty String")
    public void getStation_shouldReturnEmptyString()
    {
        Bogie b = new Bogie("");
        Assertions.assertEquals("", b.getStationName());
    }
}
