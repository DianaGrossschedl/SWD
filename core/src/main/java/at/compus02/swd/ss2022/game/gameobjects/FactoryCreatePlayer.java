package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.utils.Array;

public class FactoryCreatePlayer extends FactoryCreateTile{

    public Array<GameObject> setPlayer(String player, Array<GameObject> gameObjects){
        float x = -15;
        float y = -15;
        //Array<GameObject> gameObjects = new Array<>();
        gameObjects.add(getTile(player));
        gameObjects.get(gameObjects.size-1).setPosition(x, y);

        return gameObjects;
    }

}
