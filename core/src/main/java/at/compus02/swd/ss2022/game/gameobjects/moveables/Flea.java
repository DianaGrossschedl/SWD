package at.compus02.swd.ss2022.game.gameobjects.moveables;

import at.compus02.swd.ss2022.game.observer.MovementObserver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Flea extends Player {

    private boolean movesToDog;
    MovementObserver movementObserver;


    public Flea() {
        image = new Texture("flea.png");
        sprite = new Sprite(image);
    }





}
