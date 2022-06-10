package at.compus02.swd.ss2022.game;

public class Observer {

    public void observe(int key) {
        if (key == 21)
            System.out.println("Bingo moved left");
        if (key == 22)
            System.out.println("Bingo moved right");
        if (key == 19)
            System.out.println("Bingo moved up");
        if (key == 20)
            System.out.println("Bingo moved down");
        if (key == 62)
            System.out.println("Bingo barked");
    }

}
