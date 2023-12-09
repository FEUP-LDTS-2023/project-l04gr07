package l04gr07.view.ElementsView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Game.FieldElements.Wall;

public class WallView extends ElementsViewer{

    private final Wall wall;

    public WallView(Wall wall, TextGraphics graphics){
        super(graphics);
        this.wall = wall;
    }
    /////////////////////
    public Wall getWall() {return wall;}

    public void drawFruit(){
        graphics.setForegroundColor(TextColor.Factory.fromString("#800080"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.putString(new TerminalPosition(wall.getPosition().getx(), wall.getPosition().gety()), "V");
    }
    public void drawIceCube(){
        graphics.setForegroundColor(TextColor.Factory.fromString("#33abf9"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.putString(new TerminalPosition(wall.getPosition().getx(), wall.getPosition().gety()), "i");
    }
    public void drawEnemy(){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.putString(new TerminalPosition(wall.getPosition().getx(), wall.getPosition().gety()), "m");
    }

    @Override
    public void draw() {
        graphics.setForegroundColor(TextColor.Factory.fromString("#2f578c"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.putString(new TerminalPosition(wall.getPosition().getx(), wall.getPosition().gety()), "W");
    }
}
