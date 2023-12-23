package l04gr07.model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuModelTest {
    @Test
    public void testMainMenuModel() {
        MainMenuModel mainMenuModel = new MainMenuModel();
        assertEquals(3, mainMenuModel.getNumberOptions());
        assertEquals("Start", mainMenuModel.getOption(0));
        assertEquals("Exit", mainMenuModel.getOption(2));
        assertFalse(mainMenuModel.isSelected(1));
        assertEquals(0, mainMenuModel.getCurrentOption());
        assertNotEquals(2, mainMenuModel.getCurrentOption());
        mainMenuModel.nextOption();
        assertEquals(1, mainMenuModel.getCurrentOption());
        assertNotEquals(2, mainMenuModel.getCurrentOption());
        assertTrue(mainMenuModel.isSelected(1));
        mainMenuModel.previousOption();
        assertEquals(0, mainMenuModel.getCurrentOption());
        assertNotEquals(1, mainMenuModel.getCurrentOption());
        assertTrue(mainMenuModel.isSelected(0));
        mainMenuModel.setRunning(true);
        assertTrue(mainMenuModel.GetRunning());
    }
}