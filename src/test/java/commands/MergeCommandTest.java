package commands;

import org.example.commands.ICommand;
import org.example.commands.MergeCommand;
import org.example.commands.MergeCommandAdapter;
import org.example.entities.Bogie;
import org.example.entities.ITrain;
import org.example.entities.TrainCHN;
import org.example.entities.TrainTVC;
import org.example.services.IMergeTrainService;
import org.example.services.ITrainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("Merge Command Test")
@ExtendWith(MockitoExtension.class)
public class MergeCommandTest {

    List<ITrain> trainList;

    @Mock
    ITrainService trainServiceMock;

    @Mock
    IMergeTrainService mergeTrainServiceMock;

    @InjectMocks
    MergeCommand mergeCommand;


    PrintStream originalOut = System.out;
    ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        trainList = new ArrayList<>();
        ITrain trainCHN = new TrainCHN("TRAIN_A");

        List<String> tokens = new ArrayList<>(List.of("TRAIN_A", "NDL", "NDL", "KRN", "GHY", "SLM", "NJP", "NGP", "BLR"));
        for (int i = 1; i < tokens.size(); i++) {
            Bogie bogie = new Bogie(tokens.get(i));
            trainCHN.addBogie(bogie);
        }

        ITrain trainTVC = new TrainTVC("TRAIN_B");

        tokens.clear();
        tokens.addAll(List.of("TRAIN_B", "NJP", "GHY", "AGA", "PNE", "MAO", "BPL", "PTA"));
        for (int i = 1; i < tokens.size(); i++) {
            Bogie bogie = new Bogie(tokens.get(i));
            trainTVC.addBogie(bogie);
        }
        trainList.add(trainCHN);
        trainList.add(trainTVC);

        trainServiceMock.addTrain(trainCHN);
        trainServiceMock.addTrain(trainTVC);
        System.setOut(new PrintStream(outputCaptor));
    }

    @Test
    public void executeTest() {

        List<String> token = List.of("MERGE");
        mergeCommand.execute();

        String actual = outputCaptor.toString().trim();
        String expected = "";

        Assertions.assertEquals(expected, actual);
    }
}
