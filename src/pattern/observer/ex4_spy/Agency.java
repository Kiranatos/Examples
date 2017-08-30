package pattern.observer.ex4_spy;

import pattern.observer.ex4_spy.people.Spy;

public class Agency {
    
    private Congress congress;
    private Spy[] staff;

    public Agency(Congress congress) {
        this.congress = congress;
    }
    
    public void call(String agentName, Message[] secrets){
        System.out.print(agentName + " надіслав доклад![");
        for (int i=0; i < secrets.length; i++)
            System.out.print(secrets[i] + "/");
        System.out.println("]");
    }
    
    public void start(){
        staff = new Spy[10];
        for (int i=0; i < staff.length; i++) {
            String str = "Агент 00" + i;            
            staff[i] = new Spy(this.congress, this, str);
        }
    }
    
}
