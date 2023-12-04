package l04gr07.view.ElementsView.PlayerView;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.view.ElementsView.ElementsViewer;

public class Player2View extends ElementsViewer implements NormalPlayerView {

    private Player player2;
    public Player2View(Player player2, TextGraphics graphics) {
        super(graphics);
        this.player2 = player2;
    }

    @Override
    public void draw(){
        graphics.setForegroundColor(TextColor.Factory.fromString("#e2619f"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(player2.getPosition().getx(), player2.getPosition().gety()), "O");}
    }

