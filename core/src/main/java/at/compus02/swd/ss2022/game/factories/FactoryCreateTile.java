package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.*;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Dog;
import com.badlogic.gdx.utils.Array;

public class FactoryCreateTile {

    public GameObject getTile(String tile){

        switch(tile) {
            case "Sign":
                return new Sign();
            case "Stone":
                return new Stone();
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
        String tile = "Gras";

        int countTile = 0;

        for(int j = 0; j < 16; j++) {

            for (int i = 0; i < 16; i++) {

                gameObjects.add(getTile(tile));
                gameObjects.get(countTile).setPosition(x, y);
                x += 30;
                countTile+=1;
            }
            y -= 30;
            x = -240;
        }
        return gameObjects;
    }



    public void drawOneElement(String tile, Array<GameObject> gameObjects, int xCoordinate, int yCoordinate){

        gameObjects.add(getTile(tile));
        gameObjects.get(gameObjects.size-1).setPosition(calculatePosition(xCoordinate),calculatePosition(yCoordinate));

    }

    public Array<GameObject> drawElements(String tile, Array<GameObject> gameObjects){

        Integer[][] positionWater = new Integer[25][2];
                positionWater[0][0]=0;
                positionWater[0][1]=3;

                positionWater[1][0]=1;
                positionWater[1][1]=3;

                positionWater[2][0]=2;
                positionWater[2][1]=3;

                positionWater[3][0]=3;
                positionWater[3][1]=3;

                positionWater[4][0]=4;
                positionWater[4][1]=3;

                positionWater[5][0]=5;
                positionWater[5][1]=3;

                positionWater[6][0]=6;
                positionWater[6][1]=3;

                positionWater[7][0]=7;
                positionWater[7][1]=3;

                positionWater[8][0]=8;
                positionWater[8][1]=3;

                positionWater[9][0]=9;
                positionWater[9][1]=3;

                positionWater[10][0]=9;
                positionWater[10][1]=4;

                positionWater[11][0]=9;
                positionWater[11][1]=5;

                positionWater[12][0]=9;
                positionWater[12][1]=6;

                positionWater[13][0]=9;
                positionWater[13][1]=7;

                positionWater[14][0]=9;
                positionWater[14][1]=8;

                positionWater[15][0]=9;
                positionWater[15][1]=9;

                positionWater[16][0]=9;
                positionWater[16][1]=10;

                positionWater[17][0]=9;
                positionWater[17][1]=11;

                positionWater[18][0]=8;
                positionWater[18][1]=11;

                positionWater[19][0]=7;
                positionWater[19][1]=11;

                positionWater[20][0]=6;
                positionWater[20][1]=11;

                positionWater[21][0]=6;
                positionWater[21][1]=12;

                positionWater[22][0]=6;
                positionWater[22][1]=13;

                positionWater[23][0]=6;
                positionWater[23][1]=14;

                positionWater[24][0]=6;
                positionWater[24][1]=15;


        for (int i = 0; i < positionWater.length; i++) {
            gameObjects.add(getTile(tile));
            gameObjects.get(gameObjects.size-1).setPosition(calculatePosition(positionWater[i][0]), calculatePosition(positionWater[i][1]));
            System.out.println(positionWater.length);
        }



        return gameObjects;
    }

    public int calculatePosition(int coordinate){

        int position;

        position = -240 + 30 * coordinate;

        return position;
    }


}
