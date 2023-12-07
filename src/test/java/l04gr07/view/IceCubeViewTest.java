package l04gr07.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.IceCube;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.IceCubeView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class IceCubeViewTest {
    @Test
    void drawIceCube() {
        TextGraphics graphicsMock= mock(TextGraphics.class);
        IceCube iMock = mock(IceCube.class);
        when(iMock.getPosition()).thenReturn(new Position(12, 3));
        IceCubeView iView = new IceCubeView(iMock, graphicsMock);
        iView.draw();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(12, 3), "I");
    }
}
