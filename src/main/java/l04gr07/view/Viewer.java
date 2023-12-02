package l04gr07.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.control.IceCubeObserver;
import l04gr07.model.Game.GameModel;
import l04gr07.model.Model;

import java.io.IOException;

public abstract class Viewer <T extends Model> implements IceCubeObserver {
    protected T model;
    protected Screen screen;
    protected TextGraphics graphics;
    protected Boolean drawIceCube = false;

    public Viewer(T model, Screen screen) {
        this.screen = screen;
        this.model = model;
       graphics=screen.newTextGraphics();

    }
    public Screen getScreen(){return screen;}

    public abstract void draw() throws IOException;

    @Override
    public void spawnIceCube() {
        System.out.println("SPAWNED ICE CUBE");
        drawIceCube = true;
    }
    @Override
    public void deSpawnIceCube() {
        System.out.println("DESPAWNED ICE CUBE");
        drawIceCube = false;
    }
}
