package commands;

import org.example.commands.TrainBCommand;
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

@DisplayName("Train B Command Test")
@ExtendWith(MockitoExtension.class)
public class TrainBCommandTest {
    @Mock
    ITrainService trainServiceMock;

    @InjectMocks
    TrainBCommand trainBCommand;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void executeTest() {
        List<String> tokens = List.of("TRAIN_B", "NJP", "GHY", "AGA", "PNE", "MAO", "BPL", "PTA");
        trainBCommand.execute(tokens);

        verify(trainServiceMock, times(1)).addTrain(any());
        verify(trainServiceMock, times(1)).getBogiesAfterHyb(any());
    }
}
