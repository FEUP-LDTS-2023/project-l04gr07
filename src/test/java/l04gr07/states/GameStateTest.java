package l04gr07.states;

import l04gr07.control.DifficultyController;
import l04gr07.control.GameController;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.view.GameView.DifficultyView;
import l04gr07.view.GameView.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateTest {
    private GameState gameState;

    @BeforeEach
    public void setUp() throws Exception{
        gameState = new GameState();
    }

    @Test
    public void testGetters() throws Exception{
        gameState.initializing(200);
        assertNotNull(gameState.getViewer());
        assertNotNull(gameState.getControl());
        assertNotNull(gameState.getModel());
    }

    //@Test
    //test

}
