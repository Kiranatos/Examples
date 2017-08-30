package pattern;

/**
 * По сути в фасаде используется несколько делегатов.
 * Разница в том, что в примере с делегатом: один класс внутри другого, 
 * а в фасаде много классов внутри одного. 
 * Он потому и Фасад называется, ты думаешь, что общаешься с одним, 
 * а на самом деле работу делают много разных классов внутри.
 * Которые могут также между собой взаимодействовать.
*/

public class FacadeApp {    
    public static void main(String[] args) {
        Computer comp = new Computer();
        comp.copy();
    }    
}

class Computer {    //Класс-фасад
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();
    
    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() { System.out.println("Включение питания"); }
    void off() { System.out.println("Выключение питания"); }
}

class DVDRom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void load() { data = true; }
    void unload() { data = false; }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) { System.out.println("Просходит копирование с диска");}
        else { System.out.println("Вставте диск");}
    }
}