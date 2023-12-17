package l04gr07.gui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LanternGUITest {
    private LanternGUI lGUI;

    @BeforeEach
    void setUp() {
        lGUI=new LanternGUI();
    }

    @Test
    void testGameScreen() throws IOException {
        int width=30;
        int height=30;
        lGUI.createGameScreen(width, height);
        assertNotNull(lGUI.getScreen());
    }

    @Test
    void testMenuScreen() throws IOException, URISyntaxException, FontFormatException {
        int width= 80;
        int height= 24;
        lGUI.createMenuScreen(width, height);
        assertNotNull(lGUI.getScreen());
    }
    @Test
    void testWinScreen() throws IOException, URISyntaxException, FontFormatException {
        int width= 80;
        int height= 24;
        lGUI.createWinScreen(width, height);
        assertNotNull(lGUI.getScreen());
    }
    @Test
    void tesInstructionsScreen() throws IOException, URISyntaxException, FontFormatException {
        int w = 80;
        int h = 24;
        lGUI.createInstructionsScreen(w, h);
        assertNotNull(lGUI.getScreen());
    }

    @Test
    void testDifficultyScreen() throws IOException, URISyntaxException, FontFormatException {
        int w =55;
        int h =23;
        lGUI.createDifficultyScreen(w, h);
        assertNotNull(lGUI.getScreen());
    }

    @Test
    void testGameOverScreen() throws IOException, URISyntaxException, FontFormatException {
        int w=80;
        int h=24;
        lGUI.createGameOverScreen(w, h);
        assertNotNull(lGUI.getScreen());
    }
    @AfterEach
    void closed() throws IOException {
        lGUI.close();
    }
}
