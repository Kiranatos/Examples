package pattern.observer.ex4_spy.people;

import pattern.observer.ex4_spy.Congress;
import pattern.observer.ex4_spy.Message;
import pattern.observer.ex4_spy.interfaces.Observer;

public class Bandit implements Observer {
    private Congress congress;
    private String name;
    
     public Bandit(Congress congress, String name) {
        this.congress = congress;        
        this.name = name;
        congress.registerObserver(this);        
    }

    @Override
    public String getName() { return name; }
    @Override
    public String toString() { return name; }

    @Override
    public void update(Message information) {        
    }    
}
