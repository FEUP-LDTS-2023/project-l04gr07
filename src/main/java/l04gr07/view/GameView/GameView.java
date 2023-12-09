package l04gr07.view.GameView;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import l04gr07.control.IceCubeObserver;
import l04gr07.model.Game.FieldElements.Enemy;
import l04gr07.model.Game.FieldElements.Fruit;
import l04gr07.model.Game.FieldElements.Player;
import l04gr07.model.Game.FieldElements.Wall;
import l04gr07.model.Game.GameModel;
import l04gr07.view.ElementsView.*;
import l04gr07.view.ElementsView.PlayerView.HugeIceCreamView;
import l04gr07.view.ElementsView.PlayerView.Player1View;
import l04gr07.view.ElementsView.PlayerView.Player2View;
import l04gr07.view.Viewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameView extends Viewer<GameModel> implements IceCubeObserver {
    private final GameModel gameModel;

    private List<PlayerViewer> playerViewer = new ArrayList<>();
    private Player1View player1Viewer;
    private Player2View player2Viewer;
    private List<WallView>  wallViewers;
    private List<FruitView> fruitViewers;
    private List<EnemyView> enemyViewers;
    private IceShotView iceShotViewer;
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
        for(PlayerViewer player : playerViewer){player.draw();}
        //player2Viewer.draw();
        //player1Viewer.draw();
        if(drawIceCube){if( gameModel.getField().isEmpty(iceCubeViewer.getIceCube().getPosition())){iceCubeViewer.draw();}}
        if(gameModel.getField().getPlayers().size()!=playerViewer.size()) {
            playerViewer = new ArrayList<>();
            for (Player player : gameModel.getField().getPlayers()) {
                playerViewer.add(new HugeIceCreamView(player, graphics));
            }
        }
        if(gameModel.getField().getFruits().size()!=fruitViewers.size()){
            fruitViewers =new ArrayList<>();
            for(Fruit fruit : gameModel.getField().getFruits()) {
                fruitViewers.add(new FruitView(fruit, graphics));
            }
        }
        if(gameModel.getField().getEnemies().size()!=enemyViewers.size()){
            enemyViewers =new ArrayList<>();
            for(Enemy enemy : gameModel.getField().getEnemies()) {
                enemyViewers.add(new EnemyView(enemy, graphics));
            }
        }


        iceShotViewer = new IceShotView(gameModel.getField().getIceShot(), graphics);
            iceShotViewer.draw();



        if(gameModel.getField().getWalls().size()!=wallViewers.size()){
            wallViewers =new ArrayList<>();
            for(Wall wall : gameModel.getField().getWalls()) {
                wallViewers.add(new WallView(wall, graphics));
            }
        }

        for(WallView wallView : wallViewers){
            if(gameModel.getField().isFruit(wallView.getWall().getPosition())){
                wallView.drawFruit();}
            else if (drawIceCube &&gameModel.getField().isIceCube(wallView.getWall().getPosition()))
                wallView.drawIceCube();
            else if (gameModel.getField().isMonster(wallView.getWall().getPosition())!=null) {
                    wallView.drawEnemy();}

            else wallView.draw();
        }


        for(FruitView fruitView : fruitViewers) {
            if (gameModel.getField().isEmpty(fruitView.getFruit().getPosition())) {
                fruitView.draw();
            }
        }
        for(EnemyView enemyView: enemyViewers) {
            if (gameModel.getField().isEmpty(enemyView.getEnemy().getPosition())) {
                enemyView.draw();
            }
        }
        screen.refresh();


    }

    private void create(){
        if (gameModel.getField().getPlayers().size()==2) {
            //System.out.println("GAMEVIEW CREATION not HUGEICECREAM");
            player1Viewer = new Player1View(gameModel.getField().getPlayer1(), graphics);
            player2Viewer = new Player2View(gameModel.getField().getPlayer2(), graphics);
            playerViewer.add(player1Viewer);
            playerViewer.add(player2Viewer);
        }
        else{
            //System.out.println("GAMEVIEW CREATION HUGEICECREAM");
            playerViewer.clear();
            playerViewer.add(new HugeIceCreamView(gameModel.getField().getPlayers().get(0), graphics));
        }

        iceCubeViewer = new IceCubeView(gameModel.getField().getIceCube(), graphics);
        wallViewers =new ArrayList<>();
        for( Wall wall : gameModel.getField().getWalls())
            wallViewers.add( new WallView(wall, graphics));
        fruitViewers =new ArrayList<>();
        for(Fruit fruit : gameModel.getField().getFruits()) {
            fruitViewers.add(new FruitView(fruit, graphics));
        }
        enemyViewers=new ArrayList<>();
        for(Enemy enemy: gameModel.getField().getEnemies()){
            enemyViewers.add(new EnemyView(enemy, graphics));
        }
    }

}

