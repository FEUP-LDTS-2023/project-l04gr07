package l04gr07.view.GameView;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Menu.WinModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class InstructionViewTest {
    private InstructionView instructionView;
    private InstructionsModel mockInstructionsModel;
    private Screen mockScreen;

    @Test
    public void testDraw() throws IOException {
        mockInstructionsModel = mock(InstructionsModel.class);
        mockScreen = mock(Screen.class);
        TextGraphics mockTg= mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTg);
        List<String> instructionTexts = Arrays.asList(
                "Instruction1", "Instruction2", "Instruction3", "Instruction4", "Instruction5",
                "Instruction6", "Instruction7", "Instruction8", "Instruction9", "Instruction10",
                "Instruction11", "Instruction12", "Instruction13", "Instruction14", "Instruction15",
                "Instruction16", "Instruction17", "Instruction18"
        );
        when(mockInstructionsModel.getInstructions()).thenReturn(instructionTexts);
        instructionView = new InstructionView(mockInstructionsModel, mockScreen);
        instructionView.draw();
        verify(mockScreen, times(2)).refresh();
    }
}
