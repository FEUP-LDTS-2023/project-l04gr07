package l04gr07;

import l04gr07.control.Controller;
import l04gr07.control.GameController;
import l04gr07.gui.LanternGUI;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.run();

    }
}