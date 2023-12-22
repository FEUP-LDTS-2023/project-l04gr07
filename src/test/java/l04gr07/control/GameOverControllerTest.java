package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.states.GameOverState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameOverControllerTest {
    @Test
    public void testProcessKeyCharacter() throws IOException {
        GameOverState mockState = mock(GameOverState.class);
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('q');
        GameOverController controller = new GameOverController();
        controller.processKey(mockKeyStroke);
        verify(mockState, never()).stopRunning();
    }
}