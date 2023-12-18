package l04gr07.model.Game.Field;

import l04gr07.model.Game.FieldElements.IceCube;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.PlayerState.NormalPlayerState;
import l04gr07.model.Game.FieldElements.PlayerState.PlayerState;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FieldTest {
    @Test
    public void testConstructorDimensions() {
        int width = 16;
        int height = 21;
        Field field = new Field(width, height);
        assertEquals(width, field.getWidth());
        assertEquals(height, field.getHeight());
        assertNull(field.getIceCube());
        assertEquals(0, field.getWalls().size());
        assertEquals(0, field.getFruits().size());
        assertEquals(0, field.getEnemies().size());
    }

    @Test
    public void testConstructorPlayerState() throws Exception {
        int width = 16;
        int height = 21;
        NormalPlayerState playerState = new NormalPlayerState(new Position(5,3), new Position(4,4));
        long speed = 500;
        Field field = new Field(width, height, playerState, speed);
        assertEquals(width, field.getWidth());
        assertEquals(height, field.getHeight());
        assertNotNull(field.getPlayer1());
        assertNull(field.getIceCube());
        assertEquals(0, field.getWalls().size());
        assertEquals(0, field.getFruits().size());
        assertEquals(0, field.getEnemies().size());
        assertEquals(playerState, field.getPlayerState());
        assertEquals(speed, field.getSpeed());
    }

    @Test
    public void testSetAndGetIceCube() {
        int width = 16;
        int height = 21;
        Field field = new Field(width, height);
        assertNull(field.getIceCube());
        IceCube iceCube = new IceCube(5, 6);
        field.setIceCube(iceCube);
        assertEquals(iceCube, field.getIceCube());
    }

    @Test
    public void testSetGetIsPlayers() {
        int width = 16;
        int height = 21;
        Field field = new Field(width, height);
        List<Player> players = new ArrayList<>();
        players.add(new Player(2, 4));
        players.add(new Player(1, 3));
        field.setPlayers(players);
        assertEquals(players, field.getPlayers());
        assertEquals(players.get(0), field.getPlayer1());
        assertEquals(players.get(1), field.getPlayer2());
        assertTrue(field.isPlayer(new Position(2,4)));
        assertFalse(field.isPlayer(new Position(3,4)));
    }

    @Test
    public void testSetWallsAndEmpty() {
        Position position = new Position(3, 5);
        Wall wall = mock(Wall.class);
        when(wall.getPosition()).thenReturn(position);
        Field field = new Field(16,21);
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(2, 4));
        field.setWalls(walls);
        assertTrue(field.isEmpty(position));
        assertFalse(field.isEmpty(new Position(2,4)));
    }

}
