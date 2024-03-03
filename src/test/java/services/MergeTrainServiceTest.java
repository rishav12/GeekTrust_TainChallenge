package services;

import org.example.entities.Bogie;
import org.example.entities.ITrain;
import org.example.services.ITrainService;
import org.example.services.MergeTrainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


public class MergeTrainServiceTest {

    private ITrainService trainServiceMock;
    private MergeTrainService mergeTrainService;

    @BeforeEach
    public void setUp() {
        trainServiceMock = Mockito.mock(ITrainService.class);
        mergeTrainService = new MergeTrainService(trainServiceMock);
    }

    @Test
    public void testGetTrainList() {
        List<ITrain> expectedTrains = new ArrayList<>();
        ITrain train1 = Mockito.mock(ITrain.class);
        ITrain train2 = Mockito.mock(ITrain.class);
        expectedTrains.add(train1);
        expectedTrains.add(train2);

        when(trainServiceMock.getTrainList()).thenReturn(expectedTrains);

        List<ITrain> actualTrains = mergeTrainService.getTrainList();

        assertEquals(expectedTrains, actualTrains);
    }


    @Test
    public void testPrintMergedTrain() {
        ITrain trainMock = Mockito.mock(ITrain.class);
        when(trainMock.getTrainName()).thenReturn("TRAIN_XYZ");

        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("StationA"));
        bogieList.add(new Bogie("HYB"));
        bogieList.add(new Bogie("StationB"));

        when(trainMock.getAllBogies()).thenReturn(bogieList);

        when(trainServiceMock.getTrainList()).thenReturn(List.of(trainMock));

        mergeTrainService.printMergedTrain();
    }
}
