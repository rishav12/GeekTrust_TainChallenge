package commands;

import org.example.commands.CommandInvoker;
import org.example.commands.ICommand;
import org.example.exceptions.NoSuchCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Command Invoker Test")
@ExtendWith(MockitoExtension.class)
public class CommandInvokerTest {
    @Mock
    private ICommand commandMock;

    @InjectMocks
    private CommandInvoker commandInvoker;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterAndExecuteCommand() {
        String commandName = "TEST_COMMAND";
        List<String> tokens = new ArrayList<>();
        commandInvoker.register(commandName, commandMock);

        commandInvoker.executeCommand(commandName, tokens);

        verify(commandMock, times(1)).execute(tokens);
    }

    @Test
    public void testExecuteCommand_NoSuchCommandException() {
        String commandName = "INVALID_COMMAND";
        List<String> tokens = new ArrayList<>();

        assertThrows(NoSuchCommandException.class, () -> commandInvoker.executeCommand(commandName, tokens));
    }

    @Test
    public void testGetCommand_NullCommand() {
        String commandName = "INVALID_COMMAND";

        ICommand command = commandInvoker.get(commandName);

        assertNull(command);
    }

    @Test
    public void testGetCommand_ValidCommand() {
        String commandName = "VALID_COMMAND";
        ICommand expectedCommand = mock(ICommand.class);
        commandInvoker.register(commandName, expectedCommand);

        ICommand command = commandInvoker.get(commandName);

        assertNotNull(command);
        assertEquals(expectedCommand, command);
    }
}
