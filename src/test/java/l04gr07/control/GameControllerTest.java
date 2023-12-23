package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.*;
import l04gr07.model.Game.FieldElements.PlayerState.HugeIceCreamState;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Menu.WinModel;
import l04gr07.model.Model;
import l04gr07.model.Position;
import l04gr07.states.GameOverState;
import l04gr07.states.GameState;
import l04gr07.states.WinState;
import l04gr07.view.Viewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameControllerTest {
    @Test
    public void testMoveIceShotEmpty() throws Exception {
        GameState mockGameState = mock(GameState.class);
        GameModel mockGameModel = mock(GameModel.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        Field mockField = mock(Field.class);
        IceShot iceShot = new IceShot(5, 5, "NO");
        when(mockGameState.getModel()).thenReturn(mockGameModel);
        when(mockGameModel.getField()).thenReturn(mockField);
        when(mockGameState.getGUI()).thenReturn(mockGui);
        when(mockField.getIceShot()).thenReturn(iceShot);
        GameController gameController = new GameController(mockGameState, mockGameModel, 0);
        gameController.moveIceShot(iceShot, "UP");
        assertEquals(iceShot.getposition().getx(), -1);
        assertEquals(iceShot.getposition().gety(), -1);
    }

    @Test
    public void testMoveIceShot() throws Exception {
        GameState mockGameState = mock(GameState.class);
        GameModel mockGameModel = mock(GameModel.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        Field mockField = mock(Field.class);
        IceShot mockIceShot = mock(IceShot.class);
        IceShot iceShot = new IceShot(2, 2, "NO");
        when(mockGameState.getModel()).thenReturn(mockGameModel);
        when(mockGameModel.getField()).thenReturn(mockField);
        when(mockGameState.getGUI()).thenReturn(mockGui);
        when(mockField.getIceShot()).thenReturn(mockIceShot);
        when(mockIceShot.getPosition()).thenReturn(new Position(3, 2));
        when(mockField.isEmpty(any())).thenAnswer(invocation -> true);
        when(mockField.isMonster(any())).thenReturn(null);
        GameController gameController = new GameController(mockGameState, mockGameModel, 0);
        gameController.moveIceShot(iceShot, "RIGHT");
        gameController.moveIceShot(iceShot, "LEFT");
        gameController.moveIceShot(iceShot, "RIGHT");
        gameController.moveIceShot(iceShot, "DOWN");
        gameController.moveIceShot(iceShot, "DOWN");
        assertEquals(iceShot.getposition().getx(), 3);
        assertEquals(iceShot.getposition().gety(), 4);
    }


    @Test
    public void testIceShot() throws IOException, URISyntaxException, FontFormatException {
        GameState mockGameState = mock(GameState.class);
        GameModel mockGameModel = mock(GameModel.class);
        Field mockField = mock(Field.class);
        IceShot mockIceShot = mock(IceShot.class);
        when(mockGameState.getModel()).thenReturn(mockGameModel);
        when(mockGameModel.getField()).thenReturn(mockField);
        when(mockField.getIceShot()).thenReturn(mockIceShot);
        when(mockField.getIceShot().getDirection()).thenReturn("NO");
        GameController gameController = new GameController(mockGameState, mockGameModel, 0);
        gameController.IceShot();
        assertTrue(System.currentTimeMillis() - gameController.getLastMovementIce() < 10);
    }

    @Test
    public void testSetAndGetTime() {
        GameState gameState = mock(GameState.class);
        GameModel gameModel = mock(GameModel.class);
        when(gameState.getModel()).thenReturn(gameModel);
        GameController gameController = new GameController(gameState, gameModel, 0);
        gameController.setTime(3);
        assertEquals(3, gameController.getTime());
    }

    @Test
    public void testProcessKeyCharacterA() throws Exception {
        GameState gameState = mock(GameState.class);
        GameModel gameModel = mock(GameModel.class);
        Field mockField = mock(Field.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        when(gameState.getModel()).thenReturn(gameModel);
        when(gameState.getModel()).thenReturn(gameModel);
        when(gameModel.getField()).thenReturn(mockField);
        when(gameState.getGUI()).thenReturn(mockGui);
        when(gameState.getGUI()).thenReturn(mockGui);
        when(mockField.getPlayer1()).thenReturn(new Player(2, 2));
        GameController gameController = new GameController(gameState, gameModel, 0);
        KeyStroke key = KeyStroke.fromString("a");
        gameController.processKey(key);
        verify(mockGui, never()).close();
    }

    @Test
    public void testMoveEnemy() throws IOException, URISyntaxException, FontFormatException {
        GameState mockGameState = mock(GameState.class);
        GameModel mockGameModel = mock(GameModel.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        Enemy mockEnemy = mock(Enemy.class);
        Player mockPlayer = mock(Player.class);
        Field mockField = mock(Field.class);
        ArrayList<Player> mockPlayers = new ArrayList<Player>();
        mockPlayers.add(mockPlayer);
        when(mockField.getPlayers()).thenReturn(mockPlayers);
        when(mockGameState.getModel()).thenReturn(mockGameModel);
        when(mockGameModel.getField()).thenReturn(mockField);
        when(mockField.isEmpty(any())).thenReturn(true);
        when(mockGameState.getGUI()).thenReturn(mockGui);
        GameController gameController = new GameController(mockGameState, mockGameModel, 0);
        Position mockEnemyPosition = mock(Position.class);
        when(mockEnemy.getPosition()).thenReturn(mockEnemyPosition);
        Position mockPlayerPosition = mock(Position.class);
        when(mockPlayer.getPosition()).thenReturn(mockPlayerPosition);
        gameController.moveEnemy(mockEnemy, mockPlayerPosition);
        verify(mockGameState.getGUI(), never()).close();
    }

    @Test
    public void testRandomEnemy() throws IOException, URISyntaxException, FontFormatException {
        GameState mockGameState = mock(GameState.class);
        GameModel mockGameModel = mock(GameModel.class);
        Field mockField = mock(Field.class);
        when(mockGameState.getModel()).thenReturn(mockGameModel);
        when(mockGameModel.getField()).thenReturn(mockField);
        GameController gameController = new GameController(mockGameState, mockGameModel, 0);
        gameController.randomEnemy(10);
        assertTrue(System.currentTimeMillis() - gameController.getLastMovement() < 10);
    }

    @Test
    public void testRetrieveFruitsWithEmptyFruits() {
        GameState gameState = mock(GameState.class);
        Field mockField = mock(Field.class);
        Player mockPlayer1 = mock(Player.class);
        Player mockPlayer2 = mock(Player.class);
        Fruit mockFruit = mock(Fruit.class);
        GameModel mockModel = mock(GameModel.class);
        AudioController mockAudioController = mock(AudioController.class);
        when(gameState.getModel()).thenReturn(mockModel);
        when(gameState.getViewer()).thenReturn(mock(Viewer.class));
        when(gameState.getModel().getField()).thenReturn(mockField);
        when(mockField.getPlayer1()).thenReturn(mockPlayer1);
        when(mockField.getPlayer2()).thenReturn(mockPlayer2);
        when(mockFruit.getPosition()).thenReturn(new Position(1, 1));
        ArrayList<Fruit> f = new ArrayList<>();
        when(mockField.getFruits()).thenReturn(f);
        GameController gameController = new GameController(gameState, gameState.getModel(), System.currentTimeMillis());
        when(mockField.getFruits()).thenReturn(new ArrayList<>());
        gameController.retrieveFruits();
        assertTrue(gameController.iceCube);
        verify(mockField, never()).getPlayer1();
        verify(mockField, never()).getPlayer2();
        verify(mockField, times(2)).getFruits();
        assertTrue(gameController.getIceCube());
        verify(mockAudioController, never()).playAudio(anyString());
    }
}
