package services;

import org.example.entities.Bogie;
import org.example.entities.ITrain;
import org.example.services.TrainService;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("TrainServiceTest")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)

public class TrainServiceTest {


    @InjectMocks
    private TrainService trainService;

    @Mock
    private ITrain trainMock;
    @Mock
    private ITrain trainMock1;

    @Mock
    private ITrain trainMock2;

    @Mock
    private TrainService trainServiceMock;

    @Before
    public void setUp() {
        trainService = spy(new TrainService());
    }

    @Test
    public void testAddTrain() {
        ITrain newTrain = mock(ITrain.class);

        trainService.addTrain(newTrain);

        assertEquals(1, trainService.getTrainList().size());
        assertEquals(newTrain, trainService.getTrainList().get(0));
    }

    @Test
    public void testPrintTrainSummary() {
        List<Bogie> bogies1 = new ArrayList<>();
        bogies1.add(new Bogie("StationA"));
        bogies1.add(new Bogie("StationB"));

        List<Bogie> bogies2 = new ArrayList<>();
        bogies2.add(new Bogie("StationC"));
        bogies2.add(new Bogie("StationD"));

        when(trainMock1.getTrainName()).thenReturn("Train1");
        when(trainMock1.getAllBogies()).thenReturn(bogies1);
        when(trainMock2.getTrainName()).thenReturn("Train2");
        when(trainMock2.getAllBogies()).thenReturn(bogies2);

        trainService.addTrain(trainMock1);
        trainService.addTrain(trainMock2);
        trainService.printTrainSummary();

        // Verify
        verify(trainMock1, times(1)).getTrainName();
        verify(trainMock1, times(1)).getAllBogies();
        verify(trainMock2, times(1)).getTrainName();
        verify(trainMock2, times(1)).getAllBogies();
    }

}
