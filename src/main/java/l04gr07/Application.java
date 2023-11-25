package l04gr07;

import l04gr07.control.GameController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameController gameController = new GameController(55, 23);
        gameController.run();
    }
}