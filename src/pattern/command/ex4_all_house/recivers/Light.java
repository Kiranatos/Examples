package pattern.command.ex4_all_house.recivers;

//Reciver
public class Light{
    String room;
    public Light(String room) { this.room = room; }    
    public void on(){ System.out.println("Свет включён в " + room); }
    public void off(){ System.out.println("Лампочку украли"); }    
    public void dim() { System.out.println("Включён Тусклый свет"); }
}