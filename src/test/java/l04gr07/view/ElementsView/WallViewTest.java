package l04gr07.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.WallView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WallViewTest {
    @Test
    void drawWalls() {
        TextGraphics graphicsMock= mock(TextGraphics.class);
        Wall iMock = mock(Wall.class);
        when(iMock.getPosition()).thenReturn(new Position(2, 6));
        WallView iView = new WallView(iMock, graphicsMock);
        iView.draw();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#2f578c"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(2, 6), "W");
        assertEquals(iView.getWall().getPosition().getx(), 2);
    }
    @Test
    void drawFruits() {
        TextGraphics graphicsMock= mock(TextGraphics.class);
        Wall iMock = mock(Wall.class);
        when(iMock.getPosition()).thenReturn(new Position(2, 6));
        WallView iView = new WallView(iMock, graphicsMock);
        iView.drawFruit();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#800080"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(2, 6), "V");
        assertEquals(iView.getWall().getPosition().getx(), 2);
    }
    @Test
    void drawIceCube() {
        TextGraphics graphicsMock= mock(TextGraphics.class);
        Wall iMock = mock(Wall.class);
        when(iMock.getPosition()).thenReturn(new Position(2, 6));
        WallView iView = new WallView(iMock, graphicsMock);
        iView.drawIceCube();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#33abf9"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(2, 6), "i");
        assertEquals(iView.getWall().getPosition().getx(), 2);
    }
    @Test
    void drawEnemy() {
        TextGraphics graphicsMock= mock(TextGraphics.class);
        Wall iMock = mock(Wall.class);
        when(iMock.getPosition()).thenReturn(new Position(2, 6));
        WallView iView = new WallView(iMock, graphicsMock);
        iView.drawEnemy();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(2, 6), "m");
        assertEquals(iView.getWall().getPosition().getx(), 2);
    }
}
