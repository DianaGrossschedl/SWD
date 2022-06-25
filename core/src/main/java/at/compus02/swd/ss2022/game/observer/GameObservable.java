package at.compus02.swd.ss2022.game.observer;

public interface GameObservable {

    void registerObserver(GameObserver o);
    void removeObserver(GameObserver o);
    void notifyObservers();

}
