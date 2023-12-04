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
        drawText(new Position(7, 3), "\t\tInstructions", "#00CED1");
        drawText(new Position(1, 5), "Este jogo e composto por 2 players que ", "#00CED1");
        drawText(new Position(1, 6), "devem trabalhar em conjunto para matar os monstros", "#00CED1");
        drawText(new Position(1, 7), "O player1 é movido pelos setas do teclado e o player2 por 'WASD'", "#00CED1");
        screen.refresh();
    }
}
