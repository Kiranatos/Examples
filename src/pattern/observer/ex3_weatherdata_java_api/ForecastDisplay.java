package pattern.observer.ex3_weatherdata_java_api;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private Observable obs;  
    private float lastPressure, currentPressure = 29.92f;    
    
    public ForecastDisplay(Observable obs) {
        this.obs = obs;
        obs.addObserver(this);        
    }

    @Override
    public void update(Observable o, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData wD = (WeatherData)obs;
            lastPressure = currentPressure;
            currentPressure = wD.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Pressure = " + this.currentPressure);        
    }    
}
