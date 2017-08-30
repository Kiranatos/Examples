package pattern.command.ex4_all_house.commands;

import patterns.command.ex4_all_house.recivers.*;
import patterns.command.ex4_all_house.commands.Command;

public class ConcreteCommand {

    public static class NoCommand implements Command {
        public void undo() { System.out.println("Нечего не происходит..."); }
        public void execute() { System.out.println("Нечего не происходит..."); }
    }
    
    //ConcreteCommand
    
    // -------------------------------------- Свет
    public static class LightOnCommand implements Command {
        Light light;
        public LightOnCommand(Light light) { this.light = light; }
        public void execute() { light.on(); }
        public void undo() { light.off(); }
    }

    public static class LightOffCommand implements Command {
        Light light;
        public LightOffCommand(Light light) { this.light = light; }
        public void execute() { light.off(); }
        public void undo() { light.on(); }
    }
    
    // -------------------------------------- Магнитофон
    public static class StereoOnCommand implements Command {
        Stereo stereo;
        public StereoOnCommand(Stereo stereo) { this.stereo = stereo; }
        public void execute() {
            stereo.on();
            stereo.setCd();
            stereo.setVolume(11);
        }
        public void undo() { stereo.off(); }
    }

    public static class StereoOffCommand implements Command {
        Stereo stereo;
        public StereoOffCommand(Stereo stereo) { this.stereo = stereo; }
        public void execute() { stereo.off(); }
        public void undo() {
            stereo.on();
            stereo.setCd();
            stereo.setVolume(11);
        }
    }
    
    // -------------------------------------- Вентилятор
    
    public abstract class FanCommand {        
        int prevSpeed;
        CeilingFan fan;
        
        public FanCommand(CeilingFan fan) { this.fan = fan; }       
  
        public void undo() { 
            switch (prevSpeed) {
                case CeilingFan.HIGH    : fan.high(); break;
                case CeilingFan.MEDIUM  : fan.medium(); break;
                case CeilingFan.LOW     : fan.low(); break;
                case CeilingFan.OFF     : fan.off(); break;
            }
        }
    }
    
    public static class CeilingFanOnCommand implements Command {
        CeilingFan fan;
        public CeilingFanOnCommand(CeilingFan fan) { this.fan = fan; }
        public void execute() { fan.on(); }
        public void undo() { fan.off(); }
    }

    public static class CeilingFanOffCommand extends FanCommand implements Command {        
        public CeilingFanOffCommand(CeilingFan fan) { super(fan); }
        public void execute() { 
            prevSpeed = fan.getSpeed();
            fan.off(); 
        }
        public void undo() { 
            fan.on(); 
            super.undo(); 
        }
    }
    
    public static class CeilingFanHighCommand extends FanCommand implements Command {        
        public CeilingFanHighCommand(CeilingFan fan) { super(fan); }
        public void execute() {
            prevSpeed = fan.getSpeed();
            fan.high(); 
        }
    }
    
    public static class CeilingFanMediumCommand extends FanCommand implements Command {        
        public CeilingFanMediumCommand(CeilingFan fan) { super(fan); }
        public void execute() { 
            prevSpeed = fan.getSpeed();
            fan.medium(); 
        }        
    }
    
    // -------------------------------------- Гараж
    public static class GarageDoorOpenCommand implements Command {
        GarageDoor door;
        public GarageDoorOpenCommand(GarageDoor door) { this.door = door; }
        public void execute() { door.open(); }
        public void undo() { door.close(); }
    }
    
    public static class GarageDoorCloseCommand implements Command {
        GarageDoor door;
        public GarageDoorCloseCommand(GarageDoor door) { this.door = door; }
        public void execute() { door.close(); }
        public void undo() { door.open(); }
    }
    
    // -------------------------------------- Джакузи
    public static class HottubOnCommand implements Command {
        Hottub tub;
        public HottubOnCommand(Hottub tub) { this.tub = tub; }
        public void execute() { tub.on(); }
        public void undo() { tub.off(); }
    }
    
    public static class HottubOffCommand implements Command {
        Hottub tub;
        public HottubOffCommand(Hottub tub) { this.tub = tub; }
        public void execute() { tub.off(); }
        public void undo() { tub.on(); }
    }
    
    // -------------------------------------- Телевизор
    public static class TVOnCommand implements Command {
        TV tv;
        public TVOnCommand(TV tv) { this.tv = tv; }
        public void execute() { tv.on(); }
        public void undo() { tv.off(); }
    }
    
    public static class TVOffCommand implements Command {
        TV tv;
        public TVOffCommand(TV tv) { this.tv = tv; }
        public void execute() { tv.on(); }
        public void undo() { tv.off(); }
    }

}
