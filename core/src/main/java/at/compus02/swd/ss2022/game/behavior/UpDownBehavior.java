package at.compus02.swd.ss2022.game.behavior;

import at.compus02.swd.ss2022.game.gameobjects.moveables.Player;
import at.compus02.swd.ss2022.game.observer.PositionObserver;

public class UpDownBehavior extends Behavior {
    public UpDownBehavior(PositionObserver positionObserver) {
        super(positionObserver);
    }

    @Override
    public void perform(Player player) {
        super.perform(player);

        if (count % 2 == 0)
            player.moveDown();
        else
            player.moveUp();

        count++;
        chase(player);
    }

    public void chase(Player player) {
        if (positionObserver.getX() + 90 == player.getX()
                || positionObserver.getX() + 60 == player.getX()
                || positionObserver.getX() + 30 == player.getX()
                && positionObserver.getY() == player.getY()) {
            player.moveLeft();
        } else if (positionObserver.getX() - 90 == player.getX()
                || positionObserver.getX() - 60 == player.getX()
                || positionObserver.getX() - 30 == player.getX()
                && positionObserver.getY() == player.getY()) {
            player.moveRight();
        } else if (positionObserver.getY() + 90 == player.getY()
                || positionObserver.getY() + 60 == player.getY()
                || positionObserver.getY() + 30 == player.getY()
                && positionObserver.getX() == player.getX()) {
            player.moveDown();
        } else if (positionObserver.getY() - 90 == player.getY()
                || positionObserver.getY() - 60 == player.getY()
                || positionObserver.getY() - 30 == player.getY()
                && positionObserver.getX() == player.getX()) {
            player.moveUp();
        }
    }

}
