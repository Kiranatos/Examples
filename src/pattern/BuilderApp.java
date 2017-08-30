package pattern;

/**
 * Строитель (Builder) 
 */

public class BuilderApp {
    public static void main(String[] args) {
        /*
        Car c1 = new CarBuilder() //Билдер
                .buildMake("Audi") //настройка параметров
                .buildMaxSpeed(100)
                .buildTransmission(Transmission.AUTO)
                .build(); // возвращение созданного объекта Car
        
        Car c2 = new CarBuilder()
                .buildMake("Audi")
//                .buildMaxSpeed(100) - если какого-то парметра не будет, то ставится по умолчанию
                .buildTransmission(Transmission.AUTO)
                .build();
        */
        
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.BuildCar();
    }
}

enum Transmission{ MANUAL, AUTO }

class Car{
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {        this.make = make;    }
    public void setTransmission(Transmission transmission) {        this.transmission = transmission;   }
    public void setMaxSpeed(int maxSpeed) {        this.maxSpeed = maxSpeed;    }    
}

abstract class CarBuilder{
    Car car;
    void createCar() {car = new Car();}
    
    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();
    
    Car getCar() { return car; }
}

class FordMondeoBuilder extends CarBuilder {
    void buildMake() { car.setMake("FordMondeo"); }
    void buildTransmission() { car.setTransmission(Transmission.MANUAL); }
    void buildMaxSpeed() { car.setMaxSpeed(260); }
}

class SubaruBuilder extends CarBuilder {
    void buildMake() { car.setMake("Subaru"); }
    void buildTransmission() { car.setTransmission(Transmission.MANUAL); }
    void buildMaxSpeed() { car.setMaxSpeed(300); }
}

class Director { //код универсальный, не будет менятся
    CarBuilder builder;
    void setBuilder(CarBuilder b) {builder = b; }
    
    Car BuildCar (){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}


//простой пример билдера
/* 
class CarBuilder{
    String m = "Default";
    Transmission t = Transmission.MANUAL;
    int s = 120;
    
    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }
    CarBuilder buildTransmission(Transmission t){
        this.t = t;
        return this;
    }
    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }
    
    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setMaxSpeed(s);
        car.setTransmission(t);
        return car;
    }
}
*/
