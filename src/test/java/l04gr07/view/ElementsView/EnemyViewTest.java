package l04gr07.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.EnemyView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class EnemyViewTest {
    @Test

    void drawEnemy() {
        TextGraphics graphicsMock = mock(TextGraphics.class);
        Enemy eMock= mock(Enemy.class);
        when(eMock.getPosition()).thenReturn(new Position(10, 3));
        EnemyView eView= new EnemyView(eMock, graphicsMock);
        eView.draw();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(10, 3), "M");
        assertEquals(eView.getEnemy().getPosition().gety(), 3);
    }
}
