package l04gr07.model.Game.Field.Builder;

import l04gr07.model.Game.Field.Field;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Game.FieldElements.Fruit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ReadMap {
    Field field;
    String filename;

    public ReadMap(String filename) {
        this.filename = filename;
    }

    public Field processMap() {
        try {
            char[][] map = readMapFromFile(filename);
            return drawMap(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private char[][] readMapFromFile(String fileName) throws IOException {
        URL resource = ReadMap.class.getClassLoader().getResource(fileName);

        if (resource == null) {
            throw new IOException("Resource not found: " + fileName);
        }

        try {
            String decodedPath = URLDecoder.decode(resource.getFile(), StandardCharsets.UTF_8.toString());
            BufferedReader reader = new BufferedReader(new FileReader(decodedPath));

            String line;
            int rows = 0;
            int cols = 0;

            while ((line = reader.readLine()) != null) {
                rows++;
                cols = Math.max(cols, line.length());
            }
            reader.close();

            char[][] map = new char[rows][cols];

            reader = new BufferedReader(new FileReader(decodedPath));
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    map[row][col] = line.charAt(col);
                }
                row++;
            }
            reader.close();

            return map;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new IOException("Error decoding path: " + e.getMessage());
        }
    }

    public Field drawMap(char[][] map) {
        Field field = new Field(55, 23);
        List<Wall> walls = field.getWalls();
        List<Fruit> fruits = field.getFruits();
        List<Enemy> enemies=field.getEnemies();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == '*') {
                    Wall wall = new Wall(col, row);
                    walls.add(wall);
                }
                if (map[row][col] == '@') {
                    Fruit fruit = new Fruit(col, row);
                    fruits.add(fruit);
                }
                if (map[row][col] == 'M') {
                    Enemy enemy = new Enemy(col, row);
                    enemies.add(enemy);
                }
            }
        }
        return field;
    }
}