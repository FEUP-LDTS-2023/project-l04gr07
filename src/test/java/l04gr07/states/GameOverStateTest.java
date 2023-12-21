package l04gr07.states;

import l04gr07.control.DifficultyController;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.view.GameView.DifficultyView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOverStateTest {
    private GameOverState gameOverState;

    @BeforeEach
    public void setUp() throws Exception{
        gameOverState = new GameOverState();
    }

    @Test
    public void testGetters() throws Exception{
        gameOverState.initializing(200);
        assertNotNull(gameOverState.getViewer());
        assertNotNull(gameOverState.getControl());
        assertNotNull(gameOverState.getModel());
    }

    @Test
    public void testInitializing() throws Exception{
        gameOverState.initializing(200);
        assertTrue(gameOverState.getViewer() instanceof DifficultyView);
        assertTrue(gameOverState.getControl() instanceof DifficultyController);
        assertTrue(gameOverState.getModel() instanceof DifficultyModel);
    }
}
