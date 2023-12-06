package l04gr07.control;

import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Position;
import l04gr07.states.GameState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class PlayerControllerTest {
    @Test
    void canPlayerMove() throws IOException, URISyntaxException, FontFormatException {
        Field fMock= Mockito.mock(Field.class);
        GameModel gameModelMock = Mockito.mock(GameModel.class);
        GameState gameStateMock = Mockito.mock(GameState.class);
        PlayerController playerController = new PlayerController(fMock, gameModelMock, gameStateMock);
        when(fMock.getWidth()).thenReturn(15);
        when(fMock.getHeight()).thenReturn(10);
        boolean r1 = playerController.canPlayerMove(new Position(21, 3));
        boolean r2 = playerController.canPlayerMove(new Position(9, 3));
        boolean r3 = playerController.canPlayerMove(new Position(15, 3));
        assertFalse(r1);
        assertTrue(r2);
        assertFalse(r3);
    }
}
