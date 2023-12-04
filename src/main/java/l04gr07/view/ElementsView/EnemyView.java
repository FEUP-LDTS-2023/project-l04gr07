package l04gr07.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Enemy;

public class EnemyView extends ElementsViewer{
    private Enemy enemy;

    public EnemyView(Enemy enemy, TextGraphics graphics) {
        super(graphics);
        this.enemy=enemy;
    }

    @Override
    public void draw() {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.putString(new TerminalPosition(enemy.getPosition().getx(), enemy.getPosition().gety()), "M");
    }
}
