package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.WinModel;
import l04gr07.states.MainMenuState;
import l04gr07.states.WinState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WinControllerTest {

    @Test
    public void testProcessKeyArrowUp() throws Exception {
        WinModel mockWinModel = mock(WinModel.class);
        WinState mockWinState = mock(WinState.class);
        WinController winController = new WinController(mockWinModel, mockWinState);
        KeyStroke key = new KeyStroke(KeyType.ArrowUp);
        winController.processKey(key);
        verify(mockWinModel).previousOption();
    }

    @Test
    public void testProcessKeyArrowDown() throws Exception {
        WinModel mockWinModel = mock(WinModel.class);
        WinState mockWinState = mock(WinState.class);
        WinController winController = new WinController(mockWinModel, mockWinState);
        KeyStroke key = new KeyStroke(KeyType.ArrowDown);
        winController.processKey(key);
        verify(mockWinModel).nextOption();
    }

    @Test
    public void testProcessKeyCharacterA() throws Exception {
        WinModel mockWinModel = mock(WinModel.class);
        WinState mockWinState = mock(WinState.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        when(mockWinState.getGUI()).thenReturn(mockGui);
        WinController winController = new WinController(mockWinModel, mockWinState);
        KeyStroke key=KeyStroke.fromString("a");
        winController.processKey(key);
        verify(mockGui, never()).close();
      }

    @Test
    public void testProcessKeyEnterSelected2() throws Exception {
        WinModel mockWinModel = mock(WinModel.class);
        when(mockWinModel.isSelected(2)).thenReturn(true);
        WinState mockWinState = mock(WinState.class);
        LanternGUI mockGui = mock(LanternGUI.class);
        when(mockWinState.getGUI()).thenReturn(mockGui);
        WinController winController = new WinController(mockWinModel, mockWinState);
        KeyStroke key = new KeyStroke(KeyType.Enter);
        winController.processKey(key);
        verify(mockGui, never()).close();
    }
}