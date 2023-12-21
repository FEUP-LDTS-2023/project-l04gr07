package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.states.DifficultyState;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class DifficultyControllerTest {
    @Test
    public void testProcessKeyArrows() throws IOException, URISyntaxException, FontFormatException {
        DifficultyModel mockDifficultyModel = mock(DifficultyModel.class);
        DifficultyState mockDifficultyState = mock(DifficultyState.class);
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        DifficultyController difficultyController = new DifficultyController(mockDifficultyModel, mockDifficultyState);
        difficultyController.processKey(mockKeyStroke);
        verify(mockDifficultyModel, times(1)).previousOption();
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        difficultyController.processKey(mockKeyStroke);
        verify(mockDifficultyModel, times(1)).nextOption();
    }

    @Test
    public void testProcessKeyEnter() throws IOException, URISyntaxException, FontFormatException {
        DifficultyModel mockDifficultyModel = mock(DifficultyModel.class);
        DifficultyState mockDifficultyState = mock(DifficultyState.class);
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Enter);
        DifficultyController difficultyController = new DifficultyController(mockDifficultyModel, mockDifficultyState);
        difficultyController.processKey(mockKeyStroke);
        verify(mockDifficultyModel, times(1)).isSelected(0);
    }

    @Test
    public void testProcessKeyCharacter() throws IOException, URISyntaxException, FontFormatException {
        DifficultyModel mockDifficultyModel = mock(DifficultyModel.class);
        DifficultyState mockDifficultyState = mock(DifficultyState.class);
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('a');
        DifficultyController difficultyController = new DifficultyController(mockDifficultyModel, mockDifficultyState);
        difficultyController.processKey(mockKeyStroke);
        verify(mockDifficultyState, never()).stopRunning();
     }
}
