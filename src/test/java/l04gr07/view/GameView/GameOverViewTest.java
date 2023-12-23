package l04gr07.view.GameView;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.GameOverModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameOverViewTest {
    private GameOverView gameOverView;
    private GameOverModel mockGameOverModel;
    private Screen mockScreen;

    @Test
    public void testDraw() throws IOException {
        TextGraphics mockTg= mock(TextGraphics.class);
        mockGameOverModel = mock(GameOverModel.class);
        mockScreen = mock(Screen.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTg);
        List<String> gameOverText = Arrays.asList("Game Over", "Exit");
        when(mockGameOverModel.getGameOverText()).thenReturn(gameOverText);
        gameOverView = new GameOverView(mockGameOverModel, mockScreen);
        gameOverView.draw();
        List<String> list=gameOverView.getGameOverText();
        verify(mockScreen, times(2)).refresh();
        assertEquals(list.get(1), "Exit");
    }
}
