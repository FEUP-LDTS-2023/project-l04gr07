package l04gr07.states;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import l04gr07.control.Control;
import l04gr07.control.InstructionController;
import l04gr07.gui.LanternGUI;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Model;
import l04gr07.view.GameView.InstructionView;
import l04gr07.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionState extends State{
    private InstructionView instructionView;
    private InstructionsModel instructionModel;
    private InstructionController instructionController;

    private LanternGUI gui;

    @Override
    public Viewer getViewer() {
        return instructionView;
    }

   // @Override
    public Control getControl() {
        return instructionController;
    }

    @Override
    public Model getModel() {
        return instructionModel;
    }
    public LanternGUI getGUI(){return gui;}


    @Override
    public void initializing(long time) throws IOException, URISyntaxException, FontFormatException {
        instructionModel = new InstructionsModel();
        gui = new LanternGUI();
        gui.createInstructionsScreen(70,65);
        instructionView = new InstructionView(instructionModel, gui.getScreen());
        instructionController = new InstructionController( this);
    }

    @Override
    public void run(long time) throws IOException, URISyntaxException, FontFormatException {
        while (true){
            instructionView.draw();
            KeyStroke key = gui.getScreen().readInput();
            instructionController.processKey(key);
        }
    }

    public void stopRunning() throws IOException {
        gui.getScreen().close();
    }
}

