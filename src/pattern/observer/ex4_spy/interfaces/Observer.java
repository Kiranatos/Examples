package pattern.observer.ex4_spy.interfaces;

import pattern.observer.ex4_spy.Message;

public interface Observer {
    public String getName();
    public void update(Message information);
}
