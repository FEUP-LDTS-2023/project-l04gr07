package l04gr07.model.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinModelTest {
    @Test
    public void testWinModel() {
        WinModel winModel = new WinModel();
        assertEquals(2, winModel.getNumberOptions());
        assertEquals("Go back to Menu", winModel.getOption(0));
        assertEquals("Exit", winModel.getOption(1));
        assertFalse(winModel.isSelected(1));
        assertEquals(0, winModel.getCurrentOption());
        winModel.nextOption();
        assertEquals(1, winModel.getCurrentOption());
        assertNotEquals(0, winModel.getCurrentOption());
        assertTrue(winModel.isSelected(1));
        winModel.previousOption();
        assertEquals(0, winModel.getCurrentOption());
        assertTrue(winModel.isSelected(0));
        winModel.setRunning(true);
        assertTrue(winModel.GetRunning());
    }
}
