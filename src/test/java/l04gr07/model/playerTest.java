package l04gr07.model;

import l04gr07.model.Game.FieldElements.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class playersTest {
    @Test
    public void moveHorizontalPlayer2(){
        Player p2= new Player(2, 1);
        p2.setPosition(p2.moveRight());
        p2.setPosition(p2.moveRight());
        p2.setPosition(p2.moveLeft());
        assertSame(p2.getPosition().getx(), 3);
    }

    @Test
    public void movePlayer1(){
        Player p1= new Player(3, 4);
        p1.setposition(p1.moveUp());
        p1.setposition(p1.moveDown());
        p1.setposition(p1.moveDown());
        p1.setposition(p1.moveLeft());
        p1.setposition(p1.moveLeft());
        p1.setposition(p1.moveRight());
        assertEquals(p1.getPosition().getx(), 2);
        assertEquals(p1.getposition().gety(), 5);
    }

    @Test
    void testGetLastDirection() {
        Player player = new Player(0, 0);
        player.setLastDirection("UP");
        String lastDirection = player.getLastDirection();
        assertEquals("UP", lastDirection);
        player.setLastDirection("DOWN");
        assertEquals("DOWN", player.getLastDirection());
    }

}