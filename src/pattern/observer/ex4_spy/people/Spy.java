package pattern.observer.ex4_spy.people;

import pattern.observer.ex4_spy.Agency;
import pattern.observer.ex4_spy.Congress;
import pattern.observer.ex4_spy.Message;
import pattern.observer.ex4_spy.interfaces.Observer;

public class Spy implements Observer {
    private Congress congress;
    private Agency agency;
    private int n = 3;
    private Message[] secrets;
    private String name;
            

    public Spy(Congress congress, Agency agency, String name) {
        this.congress = congress;
        this.agency = agency;
        this.name = name;
        congress.registerObserver(this);
        secrets = new Message[n];        
    }

    @Override
    public void update(Message information) {
        n--;
        secrets[n] = information;
        if (n==0) {
            agency.call(name, secrets);
            congress.removeObserver(this);            
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }    
        
}
