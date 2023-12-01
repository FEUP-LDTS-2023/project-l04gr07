package l04gr07.view.GameView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.control.IceCubeObserver;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Game.GameModel;
import l04gr07.view.ElementsView.FruitView;
import l04gr07.view.ElementsView.IceCubeView;
import l04gr07.view.ElementsView.PlayerView.Player1View;
import l04gr07.view.ElementsView.PlayerView.Player2View;
import l04gr07.view.ElementsView.PlayerViewer;
import l04gr07.view.ElementsView.WallView;
import l04gr07.view.Viewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameView extends Viewer<GameModel> implements IceCubeObserver {
    private final GameModel gameModel;
    private Player1View player1Viewer;
    private Player2View player2Viewer;
    private List<WallView>  wallViewers;
    private List<FruitView> fruitViewers;
    private IceCubeView iceCubeViewer;


    public GameView(GameModel gameModel, Screen screen) throws IOException {
        super(gameModel, screen);
        this.gameModel=gameModel;
        this.create();
        this.draw();
    }


    @Override
    public void draw() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#a6bfe1"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(55, 23), ' ');
        player2Viewer.draw();
        player1Viewer.draw();
        if(drawIceCube){iceCubeViewer.draw();}
        if(gameModel.getField().getFruits().size()!=fruitViewers.size()){
            fruitViewers =new ArrayList<>();
            for(Fruit fruit : gameModel.getField().getFruits()) {
                fruitViewers.add(new FruitView(fruit, graphics));
            }
        }

        for(WallView wallView : wallViewers)
            wallView.draw();
        for(FruitView fruitView : fruitViewers) {
            fruitView.draw();
        }
        screen.refresh();


    }

    private void create(){
        player1Viewer = new Player1View(gameModel.getField().getPlayer1(), graphics);
        player2Viewer = new Player2View(gameModel.getField().getPlayer2(), graphics);
        iceCubeViewer = new IceCubeView(gameModel.getField().getIceCube(), graphics);
        wallViewers =new ArrayList<>();
        for( Wall wall : gameModel.getField().getWalls())
            wallViewers.add( new WallView(wall, graphics));
        fruitViewers =new ArrayList<>();
        for(Fruit fruit : gameModel.getField().getFruits()) {
            fruitViewers.add(new FruitView(fruit, graphics));
        }
    }

}
