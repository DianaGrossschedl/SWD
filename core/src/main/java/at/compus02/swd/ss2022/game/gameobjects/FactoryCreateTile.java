package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.utils.Array;

public class FactoryCreateTile {

    public GameObject createStartingTiles(String tile){

        switch(tile) {
            case "Sign":
                return new Sign();
            case "Bush":
                return new Bush();
            case "Gras":
                return new Tile_gras();
            case "Wall":
                return new Tile_wall();
            case "Log":
                return new Log();
            case "Water":
                return new Tile_water();
            case "Gravel":
                return new Tile_gravel();
            case "Dog":
                return new Dog();
            default:
                return null;
        }
    }

    public Array<GameObject> calculateBackground(Array<GameObject> gameObjects){
        float x = -240;
        float y = 210;

        int countTile = 0;

        for(int j = 0; j < 16; j++) {

            for (int i = 0; i < 16; i++) {
                gameObjects.add(createStartingTiles("Gras"));
                gameObjects.get(countTile).setPosition(x, y);
                x += 30;
                countTile+=1;
            }
            y -= 30;
            x = -240;
        }

        return gameObjects;


    }

    public Array<GameObject> calculateSign(Array<GameObject> gameObjects){
        float x = 0;
        float y = 0;

                gameObjects.add(createStartingTiles("Dog"));
                gameObjects.get(gameObjects.size-1).setPosition(x, y);

        return gameObjects;


    }




}
