package l04gr07.control;

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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
}
