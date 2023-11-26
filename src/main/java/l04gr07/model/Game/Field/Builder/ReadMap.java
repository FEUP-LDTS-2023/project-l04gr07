package l04gr07.model.Game.Field.Builder;
import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Game.FieldElements.Fruit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ReadMap {
    Field field;
    String filename;

    /*
    public ReadMap(String fileName, TextGraphics graphics, List<Wall> walls, List<Fruit> fruits) {
        try {
            char[][] map = readMapFromFile(fileName);
            drawMap(map, graphics, walls,fruits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    public ReadMap(String filename){this.filename = filename;}

    public Field processMap() {
        System.out.println("PROCESSED MAP");
        try {
            char[][] map = readMapFromFile(filename);
            return drawMap(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static char[][] readMapFromFile(String fileName) throws IOException {
        URL resource = ReadMap.class.getClassLoader().getResource(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        String line;
        int rows = 0; int cols = 0;

        while ((line = reader.readLine()) != null) {
            rows++;
            cols = Math.max(cols, line.length());
        }
        reader.close();

        char[][] map = new char[rows][cols];


        reader = new BufferedReader(new FileReader(resource.getFile()));
        int row = 0;
        while ((line = reader.readLine()) != null) {
            for (int col = 0; col < line.length(); col++) {
                map[row][col] = line.charAt(col);
            }
            row++;
        }
        reader.close();
        return map;
    }

    public static Field drawMap(char[][] map) {
        Field field = new Field(55,23);
        List<Wall> walls = field.getWalls();
        List<Fruit> fruits = field.getFruits();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == '*') {
                    Wall wall = new Wall(col, row);
                    walls.add(wall);

                }
                if(map[row][col] == '@'){
                    Fruit fruit = new Fruit(col, row);
                    fruits.add(fruit);

                }
            }
        }
        return field;
    }
}
