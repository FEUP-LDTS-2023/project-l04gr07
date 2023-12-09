package l04gr07.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.IceShot;
import l04gr07.view.ElementsView.PlayerView.HugeIceCreamView;

public class IceShotView extends ElementsViewer{
    private IceShot iceShot;
    public IceShotView(IceShot iceShot, TextGraphics graphics) {
        super(graphics);
        this.iceShot = iceShot;
    }

    @Override
    public void draw() {
        //   System.out.println("drew iceshot");
        graphics.setForegroundColor(TextColor.Factory.fromString("#33abf9"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.putString(new TerminalPosition(iceShot.getPosition().getx(), iceShot.getPosition().gety()), "*");
    }
}
