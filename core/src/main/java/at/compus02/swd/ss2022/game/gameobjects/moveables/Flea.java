package at.compus02.swd.ss2022.game.gameobjects.moveables;

import at.compus02.swd.ss2022.game.behavior.Behavior;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Flea extends Player {

    Behavior behavior;

    public Flea() {
        image = new Texture("flea.png");
        sprite = new Sprite(image);
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    @Override
    public void act(float delta) {
        behavior.perform(this);
    }


}
