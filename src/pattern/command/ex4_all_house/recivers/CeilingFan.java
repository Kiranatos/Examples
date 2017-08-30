package pattern.command.ex4_all_house.recivers;

//Reciver
public class CeilingFan{
    String room;
    int speed;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    public CeilingFan(String room) { this.room = room; speed = OFF; }
    
    public void on(){ System.out.println("Вентилятор включён в " + room); }
    
    public void high(){ 
        System.out.println("Вентилятор запущен на высокой скорости в " + room + ". Кот испугался и убежал");
        speed = HIGH; 
    }
    public void medium(){ 
        System.out.println("Вентилятор запущен на средней скорости в " + room + ". Кот нервничает");
        speed = MEDIUM; 
    }
    public void low(){ 
        System.out.println("Вентилятор запущен на низкой скорости в " + room + ". Кот заинтересован.");
        speed = LOW; 
    }
    public void off(){ 
        System.out.println("Вентилятор остановлен. Причина: кот застрял в лопастях в " + room);
        speed = OFF; 
    }
    
    public int getSpeed() { return speed; }
}