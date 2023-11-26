package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.states.GameState;
import l04gr07.states.State;

import java.io.IOException;

public class Controller {
    private State state;
    public void run() throws IOException {
        if (state == null) {
            state = new GameState();
            state.initializing();
        }

    }

}
