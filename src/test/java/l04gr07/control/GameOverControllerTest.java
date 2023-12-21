package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.states.GameOverState;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class GameOverControllerTest {
    private GameOverController gameOverController;
    private final LanternGUI lanternGUI= new LanternGUI();
    @Test
    public void testProcessKeyCharacter() throws URISyntaxException, FontFormatException, IOException {
        GameOverModel mockDifficultyModel = mock(GameOverModel.class);
        GameOverState mockDifficultyState = mock(GameOverState.class);
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        lanternGUI.createGameOverScreen(10,12);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('a');
        GameOverController difficultyController = new GameOverController();
        difficultyController.processKey(mockKeyStroke);
          if(mockDifficultyState.getGUI()!=null)
        verify(mockDifficultyState.getGUI().getScreen(), times(1));
    }

    @Test
    public void testExitGame() throws Exception {
        GameOverModel mockGameOverModel = mock(GameOverModel.class);
        GameOverState mockGameOverState = mock(GameOverState.class);

        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('Q');
        gameOverController = new GameOverController();
        gameOverController.processKey(mockKeyStroke);
        //verify(mockGameOverState).getGUI().getScreen().close();
        verify(mockGameOverState, never()).stopRunning();
    }
}
