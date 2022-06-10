package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Dog implements GameObject {
    private Texture image;
    private Sprite sprite;
    private float currentPositionX;
    private float currentPositionY;


    public float getCurrentPositionX() {
        return currentPositionX;
    }

    public float getCurrentPositionY() {
        return currentPositionY;
    }

    public Dog() {
        image = new Texture("dog.png");
        sprite = new Sprite(image);
    }
    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        currentPositionX = x;
        currentPositionY = y;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void bark() {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                new File("woof.wav"))) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
