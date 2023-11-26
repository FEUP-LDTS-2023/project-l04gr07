package l04gr07.model.Game.Difficulty;

import l04gr07.model.Game.Field.Builder.ReadMap;
import l04gr07.model.Game.Field.Field;

public class EasyDifficulty implements DifficultyStrategy{
    public Field createField(){
        ReadMap readMap = new ReadMap("easyMap.txt");
        Field field = readMap.processMap();
        return field;
    }
}
