package l04gr07.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Position;
import l04gr07.view.ElementsView.PlayerView.Player1View;
import l04gr07.view.ElementsView.PlayerView.Player2View;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PlayersViewTest {
    @Test
    void testDraw() {
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        Player player1Mock = Mockito.mock(Player.class);
        when(player1Mock.getPosition()).thenReturn(new Position(3, 5));
        Player1View player1View = new Player1View(player1Mock, graphicsMock);
        player1View.draw();
        verify(graphicsMock, times(1)).setForegroundColor(any());
        verify(graphicsMock, times(1)).enableModifiers(any());
        verify(graphicsMock, times(1)).putString(eq(new TerminalPosition(3, 5)), eq("O"));

        TextGraphics graphicsMock2 = Mockito.mock(TextGraphics.class);
        Player player2Mock = Mockito.mock(Player.class);
        when(player2Mock.getPosition()).thenReturn(new Position(2, 2));
        Player2View player2View = new Player2View(player2Mock, graphicsMock2);
        player2View.draw();
        verify(graphicsMock2, times(1)).setForegroundColor(any());
        verify(graphicsMock2, times(1)).enableModifiers(any());
        verify(graphicsMock2, times(1)).putString(eq(new TerminalPosition(2, 2)), eq("O"));
    }
}
