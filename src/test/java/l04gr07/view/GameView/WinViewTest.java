package l04gr07.view.GameView;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.WinModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class WinViewTest {
    private WinView winView;
    private WinModel mockWinModel;
    private Screen mockScreen;

    @Test
    public void testDraw() throws IOException {
        mockWinModel = mock(WinModel.class);
        mockScreen = mock(Screen.class);
        TextGraphics mockTg= mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTg);
        List<String> winOptions = Arrays.asList("Option1", "Option2", "Option3", "Option4");
        when(mockWinModel.getNumberOptions()).thenReturn(winOptions.size());
        when(mockWinModel.getOption(anyInt())).thenAnswer(invocation -> winOptions.get(invocation.getArgument(0)));
        when(mockWinModel.isSelected(anyInt())).thenReturn(false);
        winView = new WinView(mockWinModel, mockScreen);
        winView.draw();
        verify(mockScreen, times(2)).refresh();
    }
}
