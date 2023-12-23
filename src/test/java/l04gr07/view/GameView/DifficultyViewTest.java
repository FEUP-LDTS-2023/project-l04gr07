package l04gr07.view.GameView;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Game.Difficulty.EasyDifficulty;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.model.Menu.GameOverModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class DifficultyViewTest {
    private DifficultyView difficultyView;
    private DifficultyModel mockDifficultyModel;
    private Screen mockScreen;

    @Test
    public void testDraw() throws IOException {
        mockDifficultyModel = mock(DifficultyModel.class);
        mockScreen = mock(Screen.class);
        TextGraphics mockTg= mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTg);
        List<String> difficultyOptions = Arrays.asList("Easy", "Medium", "Hard");
        when(mockDifficultyModel.getNumberOptions()).thenReturn(difficultyOptions.size());
        when(mockDifficultyModel.getOption(anyInt())).thenAnswer(invocation -> difficultyOptions.get(invocation.getArgument(0)));
        when(mockDifficultyModel.isSelected(anyInt())).thenReturn(false);
        difficultyView = new DifficultyView(mockDifficultyModel, mockScreen);
        difficultyView.draw();
        verify(mockScreen, times(2)).refresh();
    }
}
