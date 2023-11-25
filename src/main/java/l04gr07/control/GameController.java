package l04gr07.control;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import l04gr07.model.Game.Field.Field;

import java.io.IOException;



public class GameController {
    private Screen screen = null;
    private int x = 10;
    private int y = 10;
    private Field field = new Field(25,25);

    private void draw() throws IOException {
        screen.clear();
        field.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        field.processKey(key);
    }


    public void run() throws IOException {
        while (true){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            if (key.getKeyType() == KeyType.EOF){break;}
        }
    }

    public GameController(int width, int heigth) {
        try {
            TerminalSize terminalSize = new TerminalSize(width, heigth);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            field = new Field(width, heigth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}