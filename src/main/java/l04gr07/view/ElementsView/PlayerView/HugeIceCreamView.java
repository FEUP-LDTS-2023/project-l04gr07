package l04gr07.view.ElementsView.PlayerView;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.view.ElementsView.ElementsViewer;
import l04gr07.view.ElementsView.PlayerViewer;

public class HugeIceCreamView extends ElementsViewer implements PlayerViewer {
    private Player player;
    public HugeIceCreamView(Player player, TextGraphics graphics) {
        super(graphics);
        this.player = player;
    }

    @Override
    public void draw() {
        //   System.out.println("DRAW HUGEICECREAM");
        graphics.setForegroundColor(TextColor.Factory.fromString("#c57d56"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(player.getPosition().getx(), player.getPosition().gety()), "8");}
}
