package at.compus02.swd.ss2022.game.gameobjects.moveables;

import at.compus02.swd.ss2022.game.observer.GameObservable;
import at.compus02.swd.ss2022.game.observer.GameObserver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class Dog extends Player implements GameObservable {

    public Dog() {
        image = new Texture("dog.png");
        sprite = new Sprite(image);
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

    @Override
    public void registerObserver(GameObserver o) {

    }

    @Override
    public void removeObserver(GameObserver o) {

    }

    @Override
    public void notifyObservers() {

    }
}
