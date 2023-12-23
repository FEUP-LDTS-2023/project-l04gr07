package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Position;
import l04gr07.states.GameState;
import l04gr07.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerControllerTest {
    @Mock
    private Field mockField;

    @Mock
    private GameController mockGameController;

    @Mock
    private GameState mockGameState;

    @Mock
    private GameModel mockGameModel;
    @Mock
    private PlayerController playerControllerr;
    @Mock
    private Player mockPlayer ;
    @Mock
    private Viewer mockViewer;
    private PlayerController playerController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockGameController.getGameState()).thenReturn(mockGameState);
        when(mockGameState.getModel()).thenReturn(mockGameModel);
        playerController= new PlayerController(mockField, mockGameController);
        playerController.setViewer(mockViewer);
    }

    @Test
    void testCanPlayerMoveTrue() throws IOException, URISyntaxException, FontFormatException {
        Position mockPosition = mock(Position.class);
        when(mockPosition.getx()).thenReturn(1);
        when(mockPosition.gety()).thenReturn(2);
        Wall mockWall = mock(Wall.class);
        Position mockWallPosition = mock(Position.class);
        when(mockWall.getPosition()).thenReturn(mockWallPosition);
        when(mockWallPosition.getx()).thenReturn(4);
        when(mockWallPosition.gety()).thenReturn(3);

        Enemy mockEnemy = mock(Enemy.class);
        Position mockEnemyPosition = mock(Position.class);
        when(mockEnemy.getPosition()).thenReturn(mockEnemyPosition);
        when(mockEnemyPosition.getx()).thenReturn(3);
        when(mockEnemyPosition.gety()).thenReturn(3);

        when(mockField.getWidth()).thenReturn(5);
        when(mockField.getHeight()).thenReturn(5);
        when(mockField.getWalls()).thenReturn(List.of(mockWall));
        when(mockField.getEnemies()).thenReturn(List.of(mockEnemy));
        boolean res= playerController.canPlayerMove(mockPosition);
        assertTrue(res);
    }
    @Test
    void testSetHugeIceCream() {
        playerController.setHugeIceCream(true);
        assertTrue(playerController.getHugeIceCream());
    }

    @Test
    void testMovePlayer() throws IOException, URISyntaxException, FontFormatException {
        Player mockPlayer = mock(Player.class);
        Position currentPosition = new Position(1, 1);
        when(mockPlayer.getPosition()).thenReturn(currentPosition);
        Position newPosition = new Position(2, 2);
        when(mockField.getWidth()).thenReturn(5);
        when(mockField.getHeight()).thenReturn(5);
        when(mockField.getWalls()).thenReturn(Collections.emptyList());
        when(mockField.getEnemies()).thenReturn(Collections.emptyList());
        playerController.movePlayer(mockPlayer, newPosition);
        verify(mockPlayer).setPosition(newPosition);
        verify(playerControllerr, never()).createWalls(any(Player.class));
        verify(playerControllerr, never()).breakWalls(any(Wall.class), anyString());
    }



    @Test
    void testCreateWallsUp() {
        when(mockPlayer.getLastDirection()).thenReturn("UP");
        when(mockPlayer.getPosition()).thenReturn(new Position(5, 5));
        when(mockField.isEmpty(any(Position.class))).thenReturn(true);
        when(mockField.isPlayer(any(Position.class))).thenReturn(false);
        boolean result = playerController.createWalls(mockPlayer);
        assertTrue(result);
        verify(mockField, times(5)).getWalls();
    }
    @Test
    void testCreateWallsDown() {
        when(mockPlayer.getLastDirection()).thenReturn("DOWN");
        when(mockPlayer.getPosition()).thenReturn(new Position(5, 0));
        when(mockField.getHeight()).thenReturn(5);
        when(mockField.isEmpty(any(Position.class))).thenReturn(true);
        when(mockField.isPlayer(any(Position.class))).thenReturn(false);

        boolean result = playerController.createWalls(mockPlayer);

        assertTrue(result);
        verify(mockField, times(mockField.getHeight())).getWalls();
    }


    @Test
    void testCreateWallsLeft() {
        when(mockPlayer.getLastDirection()).thenReturn("LEFT");
        when(mockPlayer.getPosition()).thenReturn(new Position(5, 5));
        when(mockField.isEmpty(any(Position.class))).thenReturn(true);
        when(mockField.isPlayer(any(Position.class))).thenReturn(false);
        boolean result = playerController.createWalls(mockPlayer);
        assertTrue(result);
        verify(mockField, times(5)).getWalls();
    }
    @Test
    void testCreateWallsRight() {
        when(mockPlayer.getLastDirection()).thenReturn("RIGHT");
        when(mockPlayer.getPosition()).thenReturn(new Position(0, 5));
        when(mockField.getWidth()).thenReturn(5);
        when(mockField.isEmpty(any(Position.class))).thenReturn(true);
        when(mockField.isPlayer(any(Position.class))).thenReturn(false);

        boolean result = playerController.createWalls(mockPlayer);

        assertTrue(result);
        verify(mockField, times(mockField.getWidth())).getWalls();
    }

    @Test
    void testCreateWallsInvalidDirection() {
        Field mockField = mock(Field.class);
        Player mockPlayer = mock(Player.class);
        GameController mockGameController = mock(GameController.class);
        when(mockPlayer.getLastDirection()).thenReturn("INVALID_DIRECTION");
        PlayerController playerController = new PlayerController(mockField,mockGameController);
        boolean result = playerController.createWalls(mockPlayer);
        assertFalse(result);
        verify(mockField, never()).getWalls();
    }

}
