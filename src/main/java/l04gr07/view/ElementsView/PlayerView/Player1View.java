package l04gr07.view.ElementsView.PlayerView;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.Player1;
import l04gr07.view.ElementsView.ElementsViewer;

public class Player1View  extends ElementsViewer {

    private Player player1;
    public Player1View(Player player1, TextGraphics graphics) {
        super(graphics);
        this.player1 = player1;
    }

    @Override
    public void draw(){
        graphics.setForegroundColor(TextColor.Factory.fromString("#c57d56"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(player1.getPosition().getx(), player1.getPosition().gety()), "O");}
}
