package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.gui.LanternGUI;
import l04gr07.states.GameState;
import l04gr07.states.MainMenuState;
import l04gr07.states.State;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller {
    private State controllerState;
    private Viewer viewer;

    public void run() throws IOException, URISyntaxException, FontFormatException {
        if (controllerState == null) {
            controllerState = new MainMenuState();
            controllerState.initializing();
        }
        controllerState.initializing();
    }

    public void setControllerState(State  controllerState) throws IOException, URISyntaxException, FontFormatException {
        this.controllerState = controllerState;
        this.run();}

    public State getControllerState() {return controllerState;}
}
