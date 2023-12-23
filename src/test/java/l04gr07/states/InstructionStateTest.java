package l04gr07.states;

import l04gr07.control.GameOverController;
import l04gr07.control.InstructionController;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.view.GameView.GameOverView;
import l04gr07.view.GameView.InstructionView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class InstructionStateTest {
    private InstructionState instructionState;

    @BeforeEach
    public void setUp() throws Exception{
        instructionState = new InstructionState();
    }

    @Test
    public void testGetters() throws Exception{
        instructionState.initializing(200);
        assertNotNull(instructionState.getViewer());
        assertNotNull(instructionState.getControl());
        assertNotNull(instructionState.getModel());
    }

    @Test
    public void testInitializing() throws Exception{
        instructionState.initializing(200);
        assertTrue(instructionState.getViewer() instanceof InstructionView);
        assertTrue(instructionState.getControl() instanceof InstructionController);
        assertTrue(instructionState.getModel() instanceof InstructionsModel);
    }

    @Test
    public void testRun() throws Exception{
        InstructionState instructionState = mock(InstructionState.class);
        when(instructionState.getViewer()).thenReturn(mock(InstructionView.class));
        when(instructionState.getControl()).thenReturn(mock(InstructionController.class));
        when(instructionState.getModel()).thenReturn(mock(InstructionsModel.class));
        instructionState.run(200);
        verify(instructionState, times(1)).run(200);
    }
}
