package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.IceCube;
import l04gr07.model.Position;

public class EasyDifficulty implements DifficultyStrategy{

    @Override
    public Field createField(){
        Position player1Pos = new Position(30,8);
        Position player2Pos = new Position(30,15);
        ReadMap readMap = new ReadMap("easyMap.txt", 500,player1Pos,player2Pos);
        Field field = readMap.processMap();
        field.setIceCube(new IceCube(10,10));
        return field;
    }
}
