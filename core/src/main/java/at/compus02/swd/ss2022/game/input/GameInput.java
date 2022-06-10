package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.Observer;
import at.compus02.swd.ss2022.game.gameobjects.Dog;
import at.compus02.swd.ss2022.game.gameobjects.FactoryCreatePlayer;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.InputAdapter;

import com.badlogic.gdx.Input;


public class GameInput extends InputAdapter {

    Dog dog;
    FactoryCreatePlayer pf;

    public void getDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public boolean keyDown(int keycode) {

        new Observer().observe(keycode);

        //System.out.println(keycode);
        //Dog dog = new Dog();
        if(keycode == Input.Keys.LEFT) {
            // Move left
            if(dog.getCurrentPositionX() == -240){
                // do nothing
            } else {
                dog.setPosition(dog.getCurrentPositionX() - 30, dog.getCurrentPositionY());
            }
        }
        if(keycode == Input.Keys.RIGHT) {
            // Move Right
            if(dog.getCurrentPositionX() == 210){
                // do nothing
            } else {
                dog.setPosition(dog.getCurrentPositionX() + 30, dog.getCurrentPositionY());
            }
        }
        if(keycode == Input.Keys.UP) {
            // Move Up

            if(dog.getCurrentPositionY() == 210){
                // do nothing
            } else {

                dog.setPosition(dog.getCurrentPositionX(), dog.getCurrentPositionY() + 30);
            }
        }
        if(keycode == Input.Keys.DOWN) {
            // Move Up

            if(dog.getCurrentPositionY() == -240){
                // do nothing
            } else {
                dog.setPosition(dog.getCurrentPositionX(), dog.getCurrentPositionY() - 30);
            }
        }

        if(keycode == Input.Keys.SPACE) {
            dog.bark();
        }

        return true;
    }



}
