package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.model.Menu.InstructionsModel;
import l04gr07.model.Model;
import l04gr07.model.Position;
import l04gr07.view.Viewer;

import java.io.IOException;

public class GameOverView extends MenuViewer {
    private final GameOverModel gameOverModel;
    public GameOverView(GameOverModel gameOverModel, Screen screen) throws IOException {
        super(gameOverModel, screen);
        this.gameOverModel = gameOverModel;
        this.draw();
    }

    @Override
    public void draw() throws IOException {
        drawText(new Position(7, 10), "\t\tGame Over", "#00CED1");
        drawText(new Position(2, 25), "Press 'q' to exit", "#00CED1");
        screen.refresh();
    }
}
