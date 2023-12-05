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

        drawText(new Position(15, 3), "Instructions", "#00CED1");
        drawText(new Position(1, 6), "Goal:", "#FFD700");
        drawText(new Position(7,6),"Collect all fruits, catch ice cube and", "#FFFFFF");
        drawText(new Position(7,7),"kill all monsters without being catch.","#FFFFFF");
        drawText(new Position(1,10),"Controls:","#FFD700");
        drawText(new Position(2,12),"Arrows -> move player1","#FFFFFF");
        drawText(new Position(2,13),"'WASD' -> move player2","#FFFFFF");
        drawText(new Position(2,14),"'WASD' -> move merge players","#FFFFFF");
        drawText(new Position(2,16),"'Enter' -> break walls by player1","#FFFFFF");
        drawText(new Position(2,17),"'E' -> break walls by player2","#FFFFFF");
        drawText(new Position(2,18),"'E' -> break walls by merge players","#FFFFFF");
        drawText(new Position(2,20),"Space bar -> throw iceshot by merge players","#FFFFFF");


        drawText(new Position(10,25),"( Press 'q' to EXIT )","#FFFFFF");
        screen.refresh();
    }
}
