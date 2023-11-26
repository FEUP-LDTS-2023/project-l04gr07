package l04gr07.states;
import l04gr07.view.*;
import l04gr07.model.*;
import l04gr07.control.*;

import java.io.IOException;

public abstract class State {
    public abstract Viewer getViewer();

    public abstract Control getControl();

    public abstract Model getModel();

    public abstract void initializing() throws IOException;
    public abstract void run() throws IOException;

}
