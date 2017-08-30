package pattern;

//13:02

/**
 * Абстрактная фабрика (Abstract Factory)
 * 
 * Использует набор фабричных методов 
 */

public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("RU");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();
        
        m.click();
        k.print();
        k.println();
        t.track(10, 35);        
    }
    
    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "RU": return new RuDeviceFactory();
            case "EN": return new EnDeviceFactory();
            default: throw new RuntimeException("Erorr " + lang);
        }
    }
}

interface Mouse {
    void click();
    void dbclick();
    void scroll(int direction);
}

interface Keyboard {
    void print();
    void println();    
}

interface Touchpad {
    void track(int deltaX, int deltaY);    
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class RuMouse implements Mouse {
    public void click() { System.out.println("[RuMouse] Click"); }
    public void dbclick() { System.out.println("[RuMouse] Double click"); }
    public void scroll(int direction)  { System.out.println("[RuMouse] Its a Scroll"); }
}

class RuKeyboard implements Keyboard {    
    public void print() { System.out.println("[RuKeyboard] Print"); }
    public void println() { System.out.println("[RuKeyboard] PrintLn"); }
}

class RuTouchpad implements Touchpad {
    public void track(int deltaX, int deltaY) { System.out.println("[RuTouchpad] Track"); }
}

class EnMouse implements Mouse {
    public void click() { System.out.println("[EnMouse] Click"); }
    public void dbclick() { System.out.println("[EnMouse] Double click"); }
    public void scroll(int direction)  { System.out.println("[EnMouse] Its a Scroll"); }
}

class EnKeyboard implements Keyboard {    
    public void print() { System.out.println("[EnKeyboard] Print"); }
    public void println() { System.out.println("[EnKeyboard] PrintLn"); }
}

class EnTouchpad implements Touchpad {
    public void track(int deltaX, int deltaY) { System.out.println("[EnTouchpad] Track"); }
}

class EnDeviceFactory implements DeviceFactory {
    public Mouse getMouse() { return new EnMouse(); }
    public Keyboard getKeyboard() { return new EnKeyboard(); }
    public Touchpad getTouchpad() { return new EnTouchpad(); }
}

class RuDeviceFactory implements DeviceFactory {
    public Mouse getMouse() { return new RuMouse(); }
    public Keyboard getKeyboard() { return new RuKeyboard(); }
    public Touchpad getTouchpad() { return new RuTouchpad(); }
}
