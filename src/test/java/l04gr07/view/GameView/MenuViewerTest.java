package l04gr07.view.GameView;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Model;
import l04gr07.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MenuViewerTest {
    private MenuViewer menuViewer;
    private Model mockModel;
    private Screen mockScreen;
    private TextGraphics mockTextGraphics;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockScreen = mock(Screen.class);
        mockTextGraphics = mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        menuViewer = new MenuViewer(mockModel, mockScreen) {
            @Override
            public void draw() {
            }
        };
    }

    @Test
    public void testDrawText() {
        Position position = new Position(1, 1);
        String text = "Testing";
        String color = "#FFaaFF";
        menuViewer.drawText(position, text, color);
        verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString(color));
        verify(mockTextGraphics).putString(position.getx(), position.gety(), text);
    }
}