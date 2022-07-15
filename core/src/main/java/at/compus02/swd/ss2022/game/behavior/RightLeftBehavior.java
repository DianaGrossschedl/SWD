package at.compus02.swd.ss2022.game.behavior;

import at.compus02.swd.ss2022.game.gameobjects.moveables.Player;
import at.compus02.swd.ss2022.game.observer.PositionObserver;

public class RightLeftBehavior extends Behavior {

    public RightLeftBehavior(PositionObserver positionObserver) {
        super(positionObserver);
    }

    @Override
    public void perform(Player player) {
        super.perform(player);
        if (count % 2 == 0)
            player.moveLeft();
        else
            player.moveRight();

        count++;
        runAway(player);

    }


    public void runAway(Player player) {
        if (positionObserver.getX() + 90 == player.getX()
                || positionObserver.getX() + 60 == player.getX()
                || positionObserver.getX() + 30 == player.getX()
                && positionObserver.getY() == player.getY()) {
            player.moveRight();
        }
        else if (positionObserver.getX() - 90 == player.getX()
                || positionObserver.getX() - 60 == player.getX()
                || positionObserver.getX() - 30 == player.getX()
                && positionObserver.getY() == player.getY()) {
            player.moveLeft();
        }
        else if (positionObserver.getY() + 90 == player.getY()
                || positionObserver.getY() + 60 == player.getY()
                || positionObserver.getY() + 30 == player.getY()
                && positionObserver.getX() == player.getX()) {
            player.moveUp();
        }
        else if (positionObserver.getY() - 90 == player.getY()
                || positionObserver.getY() - 60 == player.getY()
                || positionObserver.getY() - 30 == player.getY()
                && positionObserver.getX() == player.getX()) {
            player.moveDown();
        }
    }


}
