package l04gr07.control;

import l04gr07.control.Audio.AudioController;
import l04gr07.states.MainMenuState;
import l04gr07.states.State;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Controller {
    private State controllerState;
    private Viewer viewer;
    private long time;


    public void run() throws IOException, URISyntaxException, FontFormatException {
        long startTime = System.currentTimeMillis();
        time = startTime;
        if (controllerState == null) {
            controllerState = new MainMenuState();
            AudioController.getInstance().playAudio("./src/main/resources/background.wav");
            controllerState.initializing(startTime);

        }
        while(controllerState!= null ){
            controllerState.run(startTime);
        }

}


    public void setControllerState(State  controllerState) throws IOException, URISyntaxException, FontFormatException {
        this.controllerState = controllerState;
        this.controllerState.initializing(time);
        run();
    }

    public State getControllerState() {return controllerState;}

    public void setViewer(Viewer mockViewer) {
        this.viewer=mockViewer;
    }

    public Viewer getViewer() {
        return viewer;
    }
}
