package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.InstructionController;
import l04gr07.control.MainMenuController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.InstructionView;
import l04gr07.view.GameView.MainMenuView;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionState extends State{
    private InstructionView instructionView;
    private InstructionsModel instructionModel;
    private InstructionController instructionController;

    private LanternGUI gui;
    private Boolean running=false;
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
    public boolean isRunning(){return running;}
    @Override
    public void stopRunning(){running = false;}

    @Override
    public State nextState(){return new MainMenuState();}

    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        running = true;
        instructionModel = new InstructionsModel();
        gui = new LanternGUI();
        gui.createInstructionsScreen(40,30);
        instructionView = new InstructionView(instructionModel, gui.getScreen());
        instructionController = new InstructionController(instructionModel, this);
        run(time);
    }

    @Override
    public void run(long time) throws IOException {
        while (true){
            instructionView.draw();
            KeyStroke key = gui.getScreen().readInput();
            instructionController.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                gui.getScreen().close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
        }
    }
    }

