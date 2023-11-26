package l04gr07.states;

import l04gr07.control.Control;
import l04gr07.model.Model;
import l04gr07.view.Viewer;

import java.io.IOException;

public class EndScreenState extends State{
    @Override
    public Viewer getViewer() {
        return null;
    }

    @Override
    public Control getControl() {
        return null;
    }

    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public void initializing() throws IOException {

    }

    @Override
    public void run() throws IOException {

    }
}
