package pattern.command.ex2_tv_and_light;

public class LightAndTV {

    public static void main(String[] args) {
        TV tv = new TV();
        Light light = new Light();

        Command tvOn = new TvOnCommand(tv);
        Command tvOff = new TvOffCommand(tv);

        Command lightOn = new LightOffCommand(light);
        Command lightOff = new LightOnCommand(light);

        Switch switcher1 = new Switch(tvOn, tvOff);
        switcher1.on();
        switcher1.off();

        Switch switcher2 = new Switch(lightOn, lightOff);
        switcher2.on();
        switcher2.off();

    }
}

// Электроприборы
class TV {

    public void off() {
        System.out.println("TV turn off");
    }

    public void on() {
        System.out.println("TV turn on");
    }
}

class Light {

    public void turnOff() {
        System.out.println("Light turn off");
    }

    public void turnOn() {
        System.out.println("Light turn on");
    }
}

class Switch {

    private Command onCommand;
    private Command offCommand;

    public Switch(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void on() {
        onCommand.execute();
    }

    public void off() {
        offCommand.execute();
    }
}

//Классы-команды
interface Command { void execute(); }

class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class TvOnCommand implements Command {

    private TV tv;

    public TvOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.on();
    }
}

class TvOffCommand implements Command {

    private TV tv;

    public TvOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.off();
    }
}
