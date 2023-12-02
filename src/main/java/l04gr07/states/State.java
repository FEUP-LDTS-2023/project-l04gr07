package l04gr07.states;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Game.GameModel;
import l04gr07.view.*;
import l04gr07.model.*;
import l04gr07.control.*;
import l04gr07.view.GameView.GameView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State {
    public abstract Viewer getViewer();

    public abstract Control getControl();

    public abstract Model getModel();

    public abstract void initializing(long time) throws IOException, URISyntaxException, FontFormatException;
    public abstract void run(long time) throws IOException, URISyntaxException, FontFormatException;

    public abstract boolean isRunning();
    public abstract void stopRunning();

    public abstract State nextState();

}
