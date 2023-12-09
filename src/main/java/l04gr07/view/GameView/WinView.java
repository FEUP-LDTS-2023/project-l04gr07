package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Menu.WinModel;
import l04gr07.model.Position;

import java.awt.*;
import java.io.IOException;

public class WinView extends MenuViewer {
    private final WinModel winModel;

    public WinView(WinModel winModel, Screen screen) throws IOException {
        super(winModel, screen);
        this.winModel=winModel;
        this.draw();
    }

    @Override
    public void draw() throws IOException {
        drawMenu(new Position(1, 9), "\t\tYOU WON!", "#00CED1");
        for (int i = 0; i < winModel.getNumberOptions(); i++)
            drawMenu(new Position(12, 14 + i),  winModel.getOption(i), winModel.isSelected(i) ? "#00CED1" : "#FFFFFF");

        screen.refresh();
    }

    public void drawMenu(Position position, String string, String color){;
        drawText(position,string,color);
    }
}
