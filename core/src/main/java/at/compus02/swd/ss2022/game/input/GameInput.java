package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.moveables.Dog;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Flea;
import at.compus02.swd.ss2022.game.observer.GameObservable;
import at.compus02.swd.ss2022.game.observer.GameObserver;
import com.badlogic.gdx.InputAdapter;

import com.badlogic.gdx.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class GameInput extends InputAdapter implements GameObservable {

    Dog dog;
    int keycode;
    List<GameObserver> observers = new ArrayList<>();

    Flea[] fleas = new Flea[(int)(Math.random()*10)];
    Flea flea;


    public int getKeycode() {
        return keycode;
    }

    public void getDog(Dog dog) {
        this.dog = dog;
    }

    public Flea[] getFleas() {
        return fleas;
    }

    public void getFlea(Flea flea) {
        this.flea = flea;
    }

    @Override
    public boolean keyDown(int keycode) {

        this.keycode = keycode;
        this.notifyObservers();

        if (keycode == Input.Keys.LEFT && dog.getX() >= -210) {
            dog.moveLeft();
            for (int i = 0; i < fleas.length; i++) {
                fleas[i].moveRight();
            }

        }
        if (keycode == Input.Keys.RIGHT && dog.getX() <= 180) {
            dog.moveRight();
            for (int i = 0; i < fleas.length; i++) {
                fleas[i].moveLeft();
            }
        }
        if (keycode == Input.Keys.UP && dog.getY() <= 180) {
            dog.moveUp();
            for (int i = 0; i < fleas.length; i++) {
                fleas[i].moveDown();
            }
        }
        if (keycode == Input.Keys.DOWN && dog.getY() >= -210) {
            dog.moveDown();
            for (int i = 0; i < fleas.length; i++) {
                fleas[i].moveUp();
            }
        }
        if (keycode == Input.Keys.SPACE) {
            dog.bark();
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
            observer.update();
        }
    }


}
