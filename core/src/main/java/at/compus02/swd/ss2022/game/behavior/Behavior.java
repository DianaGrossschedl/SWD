package at.compus02.swd.ss2022.game.behavior;

import at.compus02.swd.ss2022.game.gameobjects.moveables.Player;
import at.compus02.swd.ss2022.game.observer.PositionObserver;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public abstract class Behavior {
    protected Player player;
    protected int count = 1;
    protected PositionObserver positionObserver;

    public Behavior(PositionObserver positionObserver) {
        this.positionObserver = positionObserver;
    }

    public void perform(Player player) {
        if (positionObserver.getX() == player.getX() && positionObserver.getY() == player.getY()) {
            hurt();
        }
    }

    public void hurt() {
        System.out.println("Bingo got hurt!!!");
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                new File("hurt.wav"))) {
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
