package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Model;
import l04gr07.model.Position;
import l04gr07.view.Viewer;

import java.io.IOException;

public class InstructionView extends MenuViewer {
    private final InstructionsModel instructionsModel;
    public InstructionView(InstructionsModel instructionsModel, Screen screen) throws IOException {
        super(instructionsModel, screen);
        this.instructionsModel = instructionsModel;
        this.draw();
    }

    @Override
    public void draw() throws IOException {
        drawText(new Position(1, 9), "\t\tBad Ice Cream : Menu", "#00CED1");
        screen.refresh();
    }
}
