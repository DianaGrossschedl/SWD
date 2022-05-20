package at.compus02.swd.ss2022.game.input;

import com.badlogic.gdx.InputAdapter;

import com.badlogic.gdx.Input;

public class GameInput extends InputAdapter  {
    @Override
    public boolean keyDown(int keycode) {

        System.out.println(keycode);
        if(keycode == Input.Keys.LEFT) {
            // Move left
        }
        if(keycode == Input.Keys.RIGHT) {
            // Move Right
        }
        return true;
    }


}
