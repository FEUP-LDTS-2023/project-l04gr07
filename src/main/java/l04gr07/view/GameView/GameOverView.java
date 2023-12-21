package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.GameOverModel;
import l04gr07.model.Position;

import java.io.IOException;
import java.util.List;

public class GameOverView extends MenuViewer {

    private List<String> gameOverText;
    public GameOverView(GameOverModel gameOverModel, Screen screen) throws IOException {
        super(gameOverModel, screen);
        this.gameOverText = gameOverModel.getGameOverText();
        this.draw();
    }

    @Override
    public void draw() throws IOException {
        drawText(new Position(7, 10), gameOverText.get(0), "#00CED1");
        drawText(new Position(2, 25), gameOverText.get(1), "#00CED1");
        screen.refresh();
    }
}
