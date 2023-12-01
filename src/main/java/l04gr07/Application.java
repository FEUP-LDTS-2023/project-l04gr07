package l04gr07;

import l04gr07.control.Controller;
import l04gr07.control.GameController;
import l04gr07.gui.LanternGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Controller controller = new Controller();
        controller.run();
    }
}