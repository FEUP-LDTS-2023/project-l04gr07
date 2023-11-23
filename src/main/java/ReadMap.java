
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ReadMap {

    public ReadMap(String fileName,TextGraphics graphics, List<Wall> walls) {
        try {
            char[][] map = readMapFromFile(fileName);
            drawMap(map, graphics, walls);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private static void drawMap(char[][] map, TextGraphics graphics, List<Wall> walls) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == '*') {
                    walls.add(new Wall(col, row));
                    graphics.setBackgroundColor(TextColor.Factory.fromString("#2f578c"));
                    graphics.setForegroundColor(TextColor.Factory.fromString("#2f578c"));
                    graphics.putString(new TerminalPosition(col, row), "M");
                }
            }
        }
    }
}
