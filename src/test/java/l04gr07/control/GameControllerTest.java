package l04gr07.control;

import l04gr07.gui.LanternGUI;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Game.FieldElements.IceShot;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Position;
import l04gr07.states.GameState;
import l04gr07.view.Viewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class GameControllerTest {
    @Test
    public void testMoveIceShotEmpty() throws Exception {
        GameState mockGameState = mock(GameState.class);
        GameModel mockGameModel = mock(GameModel.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        Field mockField = mock(Field.class);
        IceShot iceShot=new IceShot(5,5, "NO");
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
        IceShot iceShot= new IceShot(2,2, "NO");
        when(mockGameState.getModel()).thenReturn(mockGameModel);
        when(mockGameModel.getField()).thenReturn(mockField);
        when(mockGameState.getGUI()).thenReturn(mockGui);
        when(mockField.getIceShot()).thenReturn(mockIceShot);
        when(mockIceShot.getPosition()).thenReturn(new Position(3,2));
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
        GameController gameController = new GameController(gameState,gameModel,0);
        gameController.setTime(3);
        assertEquals(3,gameController.getTime());
    }
}
