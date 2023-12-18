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

        drawText(new Position(15, 1), "Instructions", "#00CED1");
        drawText(new Position(0, 3), "Goal:", "#FFD700");
        drawText(new Position(1,4),"Collect all fruits and catch the ice cube", "#FFFFFF");
        drawText(new Position(1,5),"to enter in Huge IceCream mode. Now, work","#FFFFFF");
        drawText(new Position(1,6),"together to kill all monsters without","#FFFFFF");
        drawText(new Position(1,7),"being caught first","#FFFFFF");
        drawText(new Position(0,10),"Controls:","#FFD700");
        drawText(new Position(2,11),"Arrows -> move player1","#FFFFFF");
        drawText(new Position(2,12),"'WASD' -> move player2","#FFFFFF");
        drawText(new Position(2,13),"'WASD' -> move player in Huge Icecream","#FFFFFF");
        drawText(new Position(1,14),"mode","#FFFFFF");
        drawText(new Position(2,15),"'Enter' -> break/create walls by player1","#FFFFFF");
        drawText(new Position(2,16),"'E' -> break/create walls by player2", "#FFFFFF");
        drawText(new Position(2,17),"'E' -> break/create walls by player in","#FFFFFF");
        drawText(new Position(1,18),"Huge IceCream mode","#FFFFFF");
        drawText(new Position(2,19),"Arrows -> throw iceshot by player in","#FFFFFF");
        drawText(new Position(1,20),"Huge Icecream mode","#FFFFFF");


        drawText(new Position(10,22),"( Press 'q' to EXIT )","#FFFFFF");
        screen.refresh();
    }
}
