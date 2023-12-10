package l04gr07.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.IceShot;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.IceShotView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class IceShotViewTest {
    @Test
    void drawIceShot() {
        TextGraphics graphicsMock= mock(TextGraphics.class);
        IceShot iMock = mock(IceShot.class);
        when(iMock.getPosition()).thenReturn(new Position(2, 6));
        IceShotView iView = new IceShotView(iMock, graphicsMock);
        iView.draw();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#33abf9"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(2, 6), "*");
    }
}
