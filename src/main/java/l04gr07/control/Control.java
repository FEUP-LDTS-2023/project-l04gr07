package l04gr07.control;

import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface Control {
    void processKey(KeyStroke key) throws IOException, URISyntaxException, FontFormatException;
}
