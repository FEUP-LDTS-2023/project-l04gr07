package l04gr07.view.GameView;

import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Menu.MainMenuModel;
import l04gr07.model.Model;
import l04gr07.view.Viewer;

public abstract class MenuViewer extends Viewer<MainMenuModel> {
    public MenuViewer(MainMenuModel model, Screen screen) {
        super(model, screen);
    }
}
