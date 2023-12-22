package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.WinController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.WinModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.WinView;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class WinState extends State{
    private WinView winView;
    private WinModel winModel;
    private WinController winControl;

    private LanternGUI gui;


    @Override
    public Viewer getViewer() {
        return winView;
    }
    @Override
    public Control getControl() {
        return winControl;
    }

    @Override
    public Model getModel() {
        return winModel;
    }

    public LanternGUI getGUI(){return gui;}

    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        winModel = new WinModel();
        gui = new LanternGUI();
        gui.createWinScreen(40,30);
        winView = new WinView(winModel, gui.getScreen());
        winControl = new WinController(winModel,this);
    }

    @Override
    public void run(long time) throws IOException, URISyntaxException, FontFormatException {
        while (true){
            winView.draw();
            KeyStroke key = gui.getScreen().readInput();
            winControl.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                gui.getScreen().close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
        }
    }

    public void stopRunning() throws IOException {
        gui.getScreen().close();
    }
}
