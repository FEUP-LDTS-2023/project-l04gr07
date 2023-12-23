package l04gr07.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewerTest {
    private Viewer<Model> viewer;
    private Model mockModel;
    private Screen mockScreen;
    private TextGraphics mockTextGraphics;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockScreen = mock(Screen.class);
        mockTextGraphics = mock(TextGraphics.class);

        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        viewer = new Viewer<Model>(mockModel, mockScreen) {
            @Override
            public void draw() {
            }
        };
    }

    @Test
    public void testSpawnIceCube() {
        assertFalse(viewer.getDrawIceCube());
        viewer.spawnIceCube();
        assertTrue(viewer.getDrawIceCube());
    }

    @Test
    public void testDeSpawnIceCube() {
        viewer.spawnIceCube();
        assertTrue(viewer.getDrawIceCube());
        viewer.deSpawnIceCube();
        assertFalse(viewer.getDrawIceCube());
    }

}
