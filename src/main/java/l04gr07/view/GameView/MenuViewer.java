package l04gr07.view.GameView;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Model;
import l04gr07.model.Position;
import l04gr07.view.Viewer;

import java.util.Objects;

public abstract class MenuViewer extends Viewer<Model> {
    public MenuViewer(Model model, Screen screen) {
        super(model, screen);
    }
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        if (Objects.equals(text, " ") || Objects.equals(text, "  ")) tg.setBackgroundColor(TextColor.Factory.fromString(color));
        else if (Objects.equals(text, "SHOP$")){
            for (int i = 0; i <= text.length()-1; i++) {
                tg.setBackgroundColor(tg.getCharacter(position.getx() + i, position.gety()).getBackgroundColor());
                tg.setForegroundColor(TextColor.Factory.fromString(color));
            }
        }
        else {tg.setForegroundColor(TextColor.Factory.fromString(color));}
        tg.putString(position.getx(), position.gety(), text);
    }
}
