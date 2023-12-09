package l04gr07.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.FruitView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class FruitViewTest {
    @Test
    void drawFruit() {
        TextGraphics graphicsMock = mock(TextGraphics.class);
        Fruit fMock= mock(Fruit.class);
        when(fMock.getPosition()).thenReturn(new Position(18, 2));
        FruitView fView= new FruitView(fMock, graphicsMock);
        fView.draw();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#800080"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(18, 2), "@");
        assertEquals(fView.getFruit().getPosition().gety(), 2);
    }
}
