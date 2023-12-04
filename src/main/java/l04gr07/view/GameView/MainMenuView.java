package l04gr07.view.GameView;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Model;
import l04gr07.model.Position;

import java.io.IOException;
import java.util.Objects;

public class MainMenuView extends MenuViewer {
    private final MainMenuModel mainMenuModel;

    public MainMenuView(MainMenuModel mainMenuModel, Screen screen) throws IOException {
        super(mainMenuModel, screen);
        this.mainMenuModel=mainMenuModel;
        this.draw();
    }

    @Override
    public void draw() throws IOException {
        drawMenu(new Position(1, 9), "\t\tBad Ice Cream : Menu", "#00CED1");
        for (int i = 0; i < mainMenuModel.getNumberOptions(); i++)
            drawMenu(new Position(12, 14 + i),  mainMenuModel.getOption(i), mainMenuModel.isSelected(i) ? "#00CED1" : "#FFFFFF");

        screen.refresh();
    }

    public void drawMenu(Position position, String string, String color){;
        drawText(position,string,color);
    }
}
