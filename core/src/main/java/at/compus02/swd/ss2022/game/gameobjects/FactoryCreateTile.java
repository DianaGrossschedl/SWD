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
            default:
                return null;
        }
    }

    public Array<GameObject> calculatePositions(Array<GameObject> gameObjects){
        float x = -240;
        float y = 210;

        int amountTiles = 16;

        for(int j = 0; j < 16; j++) {

            for (int i = 0; i < amountTiles; i++) {

                gameObjects.add(createStartingTiles("Water"));
                gameObjects.get(i).setPosition(x, y);
                x += 30;

            }

            y -= 30;
            x = -240;
        }


        return gameObjects;


    }




}
