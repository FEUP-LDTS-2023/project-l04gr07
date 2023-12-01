package l04gr07.model.Game.FieldElements;

import com.googlecode.lanterna.graphics.TextGraphics;
import l04gr07.model.Position;

public abstract class Element {
    protected Position position;
    public Element(int x, int y){
        this.position= new Position(x,y);
    }

    public Position getposition(){
        return position;
    }
    public void setposition(Position position){
        this.position=position;
    }

    //public abstract void draw(TextGraphics graphics);
}
