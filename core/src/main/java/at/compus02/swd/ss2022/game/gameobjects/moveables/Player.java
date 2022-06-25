package at.compus02.swd.ss2022.game.gameobjects.moveables;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.moveables.Moveable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements GameObject, Moveable {

    protected Texture image;
    protected Sprite sprite;
    private float xCoordinate;
    private float yCoordinate;


    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        xCoordinate = x;
        yCoordinate = y;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public float getX() {
        return xCoordinate;
    }

    public float getY() {
        return yCoordinate;
    }

    @Override
    public void moveUp() { this.setPosition(this.getX(), this.getY() + 30);}

    @Override
    public void moveDown() {
        this.setPosition(this.getX(), this.getY() - 30);
    }

    @Override
    public void moveRight() {
        this.setPosition(this.getX() + 30, this.getY());
    }

    @Override
    public void moveLeft() {
        this.setPosition(this.getX() - 30, this.getY());
    }

}
