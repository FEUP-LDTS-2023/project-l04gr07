package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.states.InstructionState;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class InstructionControllerTest {
    @Test
    public void testProcessKeyCharacter() throws IOException, URISyntaxException, FontFormatException {
        InstructionState mockState = mock(InstructionState.class);
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('a');
        InstructionController controller = new InstructionController(mockState);
        controller.processKey(mockKeyStroke);
        verify(mockState, never()).stopRunning();
    }
}
