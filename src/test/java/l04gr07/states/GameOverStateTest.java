package l04gr07.states;

import l04gr07.control.DifficultyController;
import l04gr07.control.GameOverController;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.view.GameView.DifficultyView;
import l04gr07.view.GameView.GameOverView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameOverStateTest {
    private GameOverState gameOverState;

    @BeforeEach
    public void setUp() throws Exception{
        gameOverState = new GameOverState();
        gameOverState.initializing(200);
    }

    @Test
    public void testGetters() throws Exception{
        assertNotNull(gameOverState.getViewer());
        assertNotNull(gameOverState.getControl());
        assertNotNull(gameOverState.getModel());
    }

    @Test
    public void testInitializing() throws Exception{
        assertTrue(gameOverState.getViewer() instanceof GameOverView);
        assertTrue(gameOverState.getControl() instanceof GameOverController);
        assertTrue(gameOverState.getModel() instanceof GameOverModel);
    }

    @Test
    public void testRun() throws Exception{
        GameOverState gameOverState = mock(GameOverState.class);
        when(gameOverState.getViewer()).thenReturn(mock(GameOverView.class));
        when(gameOverState.getControl()).thenReturn(mock(GameOverController.class));
        when(gameOverState.getModel()).thenReturn(mock(GameOverModel.class));
        gameOverState.run(200);
        verify(gameOverState, times(1)).run(200);
    }
}
