package l04gr07.states;

import com.googlecode.lanterna.terminal.swing.TerminalScrollController;
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
    public void initializing(long time) throws IOException {

    }

    @Override
    public void run(long time) throws IOException {

    }
}
