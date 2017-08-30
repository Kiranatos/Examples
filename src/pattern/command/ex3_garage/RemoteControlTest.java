package pattern.command.ex3_garage;

//Client
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }    
}

//Reciver
class Light{
    public void on(){}
    public void off(){}
}
class GarageDoor{
    public void up(){}
    public void down(){}
    public void stop(){}
    public void lightOn(){}
    public void lightOff(){}
}

interface Command {
    public void execute();
}

//ConcreteCommand
class LightOnCommand implements Command {    
    Light light;    
    LightOnCommand(Light light) { this.light = light; }    
    public void execute() { light.on(); }
}

class GarageDoorOpenCommand implements Command {    
    GarageDoor garageDoor;    
    GarageDoorOpenCommand(GarageDoor garageDoor) { this.garageDoor=garageDoor; }
    public void execute() { garageDoor.up(); }
}

//invoker
class SimpleRemoteControl {
    Command slot;
    SimpleRemoteControl() {}
    public void setCommand(Command command) { slot = command; }
    public void buttonWasPressed() { slot.execute(); }
}