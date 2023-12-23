package l04gr07.view.GameView;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.MainMenuModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MainMenuViewTest {
    private MainMenuView mainMenuView;
    private MainMenuModel mockMainMenuModel;
    private Screen mockScreen;

    @Test
    public void testDraw() throws IOException {
        mockMainMenuModel = mock(MainMenuModel.class);
        mockScreen = mock(Screen.class);
        TextGraphics mockTg= mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTg);
        List<String> menuOptions = Arrays.asList("Start Game", "Options", "End");
        when(mockMainMenuModel.getNumberOptions()).thenReturn(menuOptions.size());
        when(mockMainMenuModel.getOption(anyInt())).thenAnswer(invocation -> menuOptions.get(invocation.getArgument(0)));
        when(mockMainMenuModel.isSelected(anyInt())).thenReturn(false);
        mainMenuView = new MainMenuView(mockMainMenuModel, mockScreen);
        mainMenuView.draw();
        verify(mockScreen, times(2)).refresh();
    }
}
