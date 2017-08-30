package pattern.observer.ex4_spy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import pattern.observer.ex4_spy.interfaces.Observer;
import pattern.observer.ex4_spy.interfaces.Subject;
import pattern.observer.ex4_spy.people.Cat;

public class Congress implements Subject {
    private Map<String, Observer> participants = new HashMap <String, Observer>();
    private Iterator<Map.Entry<String, Observer>> it;

    @Override
    public void registerObserver(Observer o) {
        participants.put(o.getName(), o);
    }

    @Override
    public void removeObserver(Observer o) {        
        if ( participants.containsKey(o.getName()) ) {
            //participants.remove(o.getName());            
            it.remove();
            System.out.println(o.getName() + " покинув З'їзд корупціонерів.");
        }
    }

    @Override
    public void notifyObservers(Message information) {
        
        Cat cat = new Cat(this);
        
        //Iterator<Map.Entry<String, Observer>> it = participants.entrySet().iterator();
        it = participants.entrySet().iterator();
        while ( it.hasNext() ) {
            Map.Entry<String, Observer> pair = it.next();
            String name = pair.getKey();
            Observer person = (Observer)pair.getValue();             
            if ( cat.action(person) ) {
                it.remove();
            } else {
                person.update(information);
            }
                
            //System.out.print(person.getName() + " ");
        }
    }
    
    public void startLecture(Message information) {
        System.out.println("===[ тема докладу \"" + information.toString().toUpperCase() + "\"]===");
        notifyObservers(information);
    }
}