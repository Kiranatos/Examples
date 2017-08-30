package pattern.observer.ex4_spy.interfaces;

import pattern.observer.ex4_spy.Message;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(Message information);
}
