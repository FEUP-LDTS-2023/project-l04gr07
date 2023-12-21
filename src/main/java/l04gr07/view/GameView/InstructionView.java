package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Model;
import l04gr07.model.Position;
import l04gr07.view.Viewer;

import java.io.IOException;
import java.util.List;

public class InstructionView extends MenuViewer {

    private List<String> instructions;
    public InstructionView(InstructionsModel instructionsModel, Screen screen) throws IOException {
        super(instructionsModel, screen);
        this.instructions = instructionsModel.getInstructions();
        this.draw();
    }

    @Override
    public void draw() throws IOException {
        drawText(new Position(15, 1), instructions.get(0), "#00CED1");
        drawText(new Position(0, 3), instructions.get(1), "#FFD700");
        drawText(new Position(1,4),instructions.get(2), "#FFFFFF");
        drawText(new Position(1,5),instructions.get(3),"#FFFFFF");
        drawText(new Position(1,6),instructions.get(4),"#FFFFFF");
        drawText(new Position(1,7),instructions.get(5),"#FFFFFF");
        drawText(new Position(0,10),instructions.get(6),"#FFD700");
        drawText(new Position(2,11),instructions.get(7),"#FFFFFF");
        drawText(new Position(2,12),instructions.get(8),"#FFFFFF");
        drawText(new Position(2,13),instructions.get(9),"#FFFFFF");
        drawText(new Position(1,14),instructions.get(10),"#FFFFFF");
        drawText(new Position(2,15),instructions.get(11),"#FFFFFF");
        drawText(new Position(2,16),instructions.get(12), "#FFFFFF");
        drawText(new Position(2,17),instructions.get(13),"#FFFFFF");
        drawText(new Position(1,18),instructions.get(14),"#FFFFFF");
        drawText(new Position(2,19),instructions.get(15),"#FFFFFF");
        drawText(new Position(1,20),instructions.get(16),"#FFFFFF");
        drawText(new Position(10,22),instructions.get(17),"#FFFFFF");

        screen.refresh();
    }
}
