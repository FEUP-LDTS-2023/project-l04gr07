package l04gr07.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Model;

import java.io.IOException;

public abstract class Viewer <T extends Model>{
    protected T model;
    protected Screen screen;
    protected TextGraphics graphics;

    public Viewer(T model, Screen screen) {
        this.screen = screen;
        this.model = model;
       graphics=screen.newTextGraphics();

    }
    public Screen getScreen(){return screen;}

    public abstract void draw() throws IOException;
}
