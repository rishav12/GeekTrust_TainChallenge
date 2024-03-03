package commands;

import org.example.commands.TrainACommand;
import org.example.services.ITrainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("Train A Command Test")
@ExtendWith(MockitoExtension.class)
public class TrainACommandTest {

    @Mock
    ITrainService trainServiceMock;

    @InjectMocks
    TrainACommand trainACommand;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void executeTest() {
        List<String> tokens = List.of("TRAIN_A", "NDL", "KRN", "GHY");
        trainACommand.execute(tokens);

        verify(trainServiceMock, times(1)).addTrain(any());
        verify(trainServiceMock, times(1)).getBogiesAfterHyb(any());
    }
}
