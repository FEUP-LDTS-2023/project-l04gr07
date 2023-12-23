package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.states.MainMenuState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class MainMenuControllerTest {
    @Test
    public void testProcessKeyArrowUp() throws Exception {
        MainMenuModel mockMainMenuModel = mock(MainMenuModel.class);
        MainMenuState mockMainMenuState = mock(MainMenuState.class);
        MainMenuController mainMenuController = new MainMenuController(mockMainMenuModel, mockMainMenuState);
        KeyStroke key = new KeyStroke(KeyType.ArrowUp);
        mainMenuController.processKey(key);
        verify(mockMainMenuModel).previousOption();
    }

    @Test
    public void testProcessKeyArrowDown() throws Exception {
        MainMenuModel mockMainMenuModel = mock(MainMenuModel.class);
        MainMenuState mockMainMenuState = mock(MainMenuState.class);
        MainMenuController mainMenuController = new MainMenuController(mockMainMenuModel, mockMainMenuState);
        KeyStroke key = new KeyStroke(KeyType.ArrowDown);
        mainMenuController.processKey(key);
        verify(mockMainMenuModel).nextOption();
    }

    @Test
    public void testProcessKeyEnterSelected3() throws Exception {
        MainMenuModel mockMainMenuModel = mock(MainMenuModel.class);
        when(mockMainMenuModel.isSelected(3)).thenReturn(true);
        MainMenuState mockMainMenuState = mock(MainMenuState.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        when(mockMainMenuState.getGUI()).thenReturn(mockGui);
        MainMenuController mainMenuController = new MainMenuController(mockMainMenuModel, mockMainMenuState);
        KeyStroke key = new KeyStroke(KeyType.Enter);
        mainMenuController.processKey(key);
        verify(mockGui, never()).close();
    }

    @Test
    public void testProcessKeyCharacterA() throws Exception {
        MainMenuModel mockMainMenuModel = mock(MainMenuModel.class);
        MainMenuState mockMainMenuState = mock(MainMenuState.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        when(mockMainMenuState.getGUI()).thenReturn(mockGui);
        MainMenuController mainMenuController = new MainMenuController(mockMainMenuModel, mockMainMenuState);
        KeyStroke key = KeyStroke.fromString("a");
        mainMenuController.processKey(key);
        verify(mockGui, never()).close();
    }
}
