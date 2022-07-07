package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.behavior.RightLeftBehavior;
import at.compus02.swd.ss2022.game.behavior.UpDownBehavior;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Dog;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Flea;
import at.compus02.swd.ss2022.game.observer.GameObservable;
import at.compus02.swd.ss2022.game.observer.GameObserver;
import com.badlogic.gdx.InputAdapter;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GameInput extends InputAdapter implements GameObservable {

    Dog dog;

    public Flea[] getFleaList() {
        return fleaList;
    }

    //ArrayList<Flea> fleaList = new ArrayList<>();
    Flea[] fleaList = new Flea[(int)(Math.random()*10)];

    Array<GameObject> gameObjects;
    int points = 0;
    int count = 0;

    public int getPoints() {
        return points;
    }

    int keycode;
    List<GameObserver> observers = new ArrayList<>();

    public void takeGameObjects(Array<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void takeDog(Dog dog) {
        this.dog = dog;
    }

    /*public void takeFlea(Flea flea) {
        fleaList.add(flea);
    }*/

    @Override
    public boolean keyDown(int keycode) {

        this.keycode = keycode;
        this.notifyObservers();

        if (keycode == Input.Keys.LEFT) {
            dog.moveLeft();
        }
        if (keycode == Input.Keys.RIGHT) {
            dog.moveRight();
        }
        if (keycode == Input.Keys.UP) {
            dog.moveUp();
        }
        if (keycode == Input.Keys.DOWN) {
            dog.moveDown();
        }
        if (keycode == Input.Keys.SPACE) {
            dog.bark();

            for (Flea flea : fleaList) {
                if (dog.getX() == flea.getX() + 30
                        || dog.getX() == flea.getX() - 30
                        && dog.getY() == flea.getY()) {
                    if (Objects.equals(flea.getBehavior().getClass(), RightLeftBehavior.class)) {
                        gameObjects.removeValue(flea, true);
                        points += 20;
                    } else if (Objects.equals(flea.getBehavior().getClass(), UpDownBehavior.class)) {
                        count++;
                        if (count >= 2) {
                            gameObjects.removeValue(flea, true);
                            points += 10;
                        }
                    }
                } else if (dog.getY() == flea.getY() + 30
                        || dog.getY() == flea.getY() - 30
                        && dog.getX() == flea.getX()) {
                    if (Objects.equals(flea.getBehavior().getClass(), RightLeftBehavior.class)) {
                        gameObjects.removeValue(flea, true);
                        points += 20;
                    } else if (Objects.equals(flea.getBehavior().getClass(), UpDownBehavior.class)) {
                        count++;
                        if (count >= 2) {
                            gameObjects.removeValue(flea, true);
                            points += 10;
                        }
                    }

                }
            }

        }
        return true;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int key;
            while ((key = br.read()) != -1) {
                this.keyDown(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerObserver(GameObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(GameObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(dog.getX(), dog.getY());
        }
    }


}
