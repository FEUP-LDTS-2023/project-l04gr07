package l04gr07.view.ElementsView;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class ElementsViewer {
    protected TextGraphics graphics;
    public ElementsViewer(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public abstract void draw();
}
