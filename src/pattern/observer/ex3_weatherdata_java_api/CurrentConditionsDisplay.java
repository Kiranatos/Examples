package pattern.observer.ex3_weatherdata_java_api;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private Observable obs;
    private float temp, humidity;
    
    public CurrentConditionsDisplay(Observable obs) {
        this.obs = obs;
        obs.addObserver(this);      // - Добавить себя в наблюдатели
        //obs.deleteObserver(this); // - Исключить себя из наблюдателей
    }
    
    @Override
    public void update(Observable obs, Object arg) {
        /**
         * Observable obs - наблюдаемый субъект
         * Object arg - объект данных, переданный notifyObservers(Object arg)
         * служит для того, чтобы передать любые данные от субъекта         
        */
        if (obs instanceof WeatherData) {
            WeatherData wD = (WeatherData)obs;
            this.temp = wD.getTemp();
            this.humidity = wD.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current condition: " + temp + "F degrees and " + humidity + "% humidity");
    }    
}
