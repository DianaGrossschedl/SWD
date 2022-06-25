package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.utils.Array;

public class FactoryCreateEnemy extends FactoryCreateTile {

    public Array<GameObject> setEnemy (String enemy, Array<GameObject> gameObjects){
        float x = 0;
        float y = 0;
        //Array<GameObject> gameObjects = new Array<>();
        gameObjects.add(getTile(enemy));
        gameObjects.get(gameObjects.size-1).setPosition(x, y);

        return gameObjects;
    }

    @Override
    public void drawOneElement(String tile, Array<GameObject> gameObjects, int xCoordinate, int yCoordinate) {
        super.drawOneElement(tile, gameObjects, xCoordinate, yCoordinate);

    }

}
