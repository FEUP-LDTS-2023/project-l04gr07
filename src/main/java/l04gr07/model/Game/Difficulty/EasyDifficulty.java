package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.IceCube;
import l04gr07.model.Position;

public class EasyDifficulty implements DifficultyStrategy{
    public Field createField(){
        ReadMap readMap = new ReadMap("easyMap.txt", 500);
        Field field = readMap.processMap();
        field.setIceCube(new IceCube(10,10));
        return field;
    }
}
