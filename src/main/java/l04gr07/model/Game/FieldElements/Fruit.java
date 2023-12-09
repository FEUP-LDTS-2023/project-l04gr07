package l04gr07.model.Game.FieldElements;

import l04gr07.model.Position;

public class Fruit extends Element  {
    public Fruit(int x, int y){
        super(x,y);
    }
    public Position getPosition() {
        return position;
    }
}
