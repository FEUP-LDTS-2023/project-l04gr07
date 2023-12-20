package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.MainMenuController;
import l04gr07.control.WinController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Menu.WinModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.MainMenuView;
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
    private Boolean running = false;

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

    @Override
    public boolean isRunning(){return running;}
    @Override
    public void startRunning(){running = true;}

    @Override
    public void stopRunning(){running = false;}

    @Override
    public State nextState(){return new GameState();}

    public LanternGUI getGUI(){return gui;}

    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        running = true;
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
}
