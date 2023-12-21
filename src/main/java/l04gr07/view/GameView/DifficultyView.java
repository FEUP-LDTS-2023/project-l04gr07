package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.DifficultyModel;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Position;

import java.io.IOException;

public class DifficultyView extends MenuViewer{

    private final DifficultyModel difficultyModel;

    public DifficultyView(DifficultyModel difficultyModel, Screen screen) throws IOException {
        super(difficultyModel, screen);
        this.difficultyModel=difficultyModel;
    }

    @Override
    public void draw() throws IOException {
        drawMenu(new Position(1, 9), "Choose Difficulty Level", "#00CED1");
        for (int i = 0; i < difficultyModel.getNumberOptions(); i++)
            drawMenu(new Position(12, 14 + i),  difficultyModel.getOption(i), difficultyModel.isSelected(i) ? "#00CED1" : "#FFFFFF");

        screen.refresh();
    }

    public void drawMenu(Position position, String string, String color){;
        drawText(position,string,color);
    }
}
