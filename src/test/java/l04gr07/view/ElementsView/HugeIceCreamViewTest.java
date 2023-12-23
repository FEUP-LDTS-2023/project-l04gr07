package l04gr07.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.PlayerView.HugeIceCreamView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class HugeIceCreamViewTest {
    @Test
    void testDraw() {
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        Player player1Mock = Mockito.mock(Player.class);
        when(player1Mock.getPosition()).thenReturn(new Position(3, 5));
        HugeIceCreamView hview = new HugeIceCreamView(player1Mock, graphicsMock);
        hview.draw();
        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#e2619f"));
        verify(graphicsMock, times(1)).enableModifiers(any());
        verify(graphicsMock, times(1)).putString(eq(new TerminalPosition(3, 5)), eq("8"));
  }
}
