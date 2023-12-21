package l04gr07.states;

import l04gr07.control.MainMenuController;
import l04gr07.control.WinController;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Menu.WinModel;
import l04gr07.view.GameView.MainMenuView;
import l04gr07.view.GameView.WinView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainMenuStateTest {
    private MainMenuState mainMenuState;

    @BeforeEach
    public void setUp() throws Exception{
        mainMenuState = new MainMenuState();
    }

    @Test
    public void testGetters() throws Exception{
        mainMenuState.initializing(200);
        assertNotNull(mainMenuState.getViewer());
        assertNotNull(mainMenuState.getControl());
        assertNotNull(mainMenuState.getModel());
    }

    @Test
    public void testInitializing() throws Exception{
        mainMenuState.initializing(200);
        assertTrue(mainMenuState.getViewer() instanceof MainMenuView);
        assertTrue(mainMenuState.getControl() instanceof MainMenuController);
        assertTrue(mainMenuState.getModel() instanceof MainMenuModel);
    }
}
