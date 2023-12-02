import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;
public class playerTest {
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
    public void testVerticalAndDrawP2() {
        Player player=new Player(2, 4);
        TextGraphics graphicsMock= mock(TextGraphics.class);
        player.draw(graphicsMock);
        verify(graphicsMock).putString(new TerminalPosition(2, 4), "O");
        player.setPosition(player.moveUp());
        player.draw(graphicsMock);
        verify(graphicsMock).putString(new TerminalPosition(2, 3), "O");
        player.setPosition(player.moveDown());
        player.setPosition(player.moveDown());
        player.setPosition(player.moveDown());
        player.draw(graphicsMock);
        verify(graphicsMock).putString(new TerminalPosition(2, 6), "O");
    }

    @Test
    public void testDrawP1() {
        Player player=new Player(2, 4);
        TextGraphics graphicsMock= mock(TextGraphics.class);
        player.setPosition(player.moveDown());
        player.draw(graphicsMock);
        verify(graphicsMock).putString(new TerminalPosition(2, 5), "O");
    }
}
