package l04gr07.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    public void testGetLeft() {
        Position pos = new Position(3, 6);
        Position left = pos.getLeft();
        assertEquals(2, left.getx());
        assertEquals(6, left.gety());
    }

    @Test
    public void testGetRight() {
        Position pos = new Position(7, 4);
        Position right = pos.getRight();
        assertEquals(8, right.getx());
        assertEquals(4, right.gety());
    }

    @Test
    public void testGetUp() {
        Position pos = new Position(2, 2);
        Position up = pos.getUp();
        assertEquals(2, up.getx());
        assertEquals(1, up.gety());
    }

    @Test
    public void testGetDown() {
        Position pos = new Position(9, 1);
        Position down = pos.getDown();
        assertEquals(9, down.getx());
        assertEquals(2, down.gety());
    }

    @Test
    public void testGetRandomPosition() {
        Position initialPosition = new Position(3, 5);
        Position randomPosition = initialPosition.getRandomPosition();
        assertTrue(
                (randomPosition.equal(initialPosition.getLeft())) ||
                        (randomPosition.equal(initialPosition.getRight())) ||
                        (randomPosition.equal(initialPosition.getUp())) ||
                        (randomPosition.equal(initialPosition.getDown()))
        );
    }

    @Test
    public void testEquals() {
        Position pos = new Position(4, 7);
        Position poss = new Position(4, 7);
        Position posss = new Position(1, 5);
        assertEquals(pos, poss);
        assertNotEquals(pos, posss);
    }
}
