package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Model;
import l04gr07.view.Viewer;

public abstract class MenuViewer extends Viewer {
    public MenuViewer(Model model, Screen screen) {
        super(model, screen);
    }
}
