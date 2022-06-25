package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.input.GameInput;

public class MovementObserver implements GameObserver{

    GameInput gameInput;

    public int getKeyCode() {
        return keyCode;
    }

    int keyCode;

    public MovementObserver(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    @Override
    public void update() {

        keyCode = gameInput.getKeycode();

        if (keyCode == 21)
            System.out.println("Bingo moved left");
        if (keyCode == 22)
            System.out.println("Bingo moved right");
        if (keyCode == 19)
            System.out.println("Bingo moved up");
        if (keyCode == 20)
            System.out.println("Bingo moved down");
        if (keyCode == 62)
            System.out.println("Bingo barked");

    }

}
