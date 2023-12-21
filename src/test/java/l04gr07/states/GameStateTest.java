package l04gr07.states;

import l04gr07.control.DifficultyController;
import l04gr07.control.GameController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Game.Difficulty.MediumDifficulty;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.view.GameView.DifficultyView;
import l04gr07.view.GameView.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;


public class GameStateTest {
    private GameState gameState;
    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;
    private LanternGUI guiMock;
    private KeyboardSimulator keyboardSimulator;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        gameModel = mock(GameModel.class);
        gameView = mock(GameView.class);
        gameController = mock(GameController.class);
        guiMock = mock(LanternGUI.class);

        gameState = new GameState(new EasyDifficulty());

        when(guiMock.getScreen().pollInput()).thenAnswer(invocation -> {
            return keyboardSimulator.getNextKey();
        });
    }

    @Test
    public void testGetters() throws IOException, URISyntaxException, FontFormatException {
        gameState.initializing(200);
        assertNotNull(gameState);
        assertNotNull(gameState.getModel());
        assertNotNull(gameState.getViewer());
        assertNotNull(gameState.getControl());
    }

    @Test
    public void testInitializing() throws IOException, URISyntaxException, FontFormatException {
        gameState.initializing(200);
        assertTrue(gameState.getModel() instanceof GameModel);
        assertTrue(gameState.getViewer() instanceof GameView);
        assertTrue(gameState.getControl() instanceof GameController);
    }
}
