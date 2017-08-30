package pattern.observer.ex3_weatherdata_java_api;

import java.util.Observable;

public class WeatherData extends Observable {    
    private float temp, humidity, pressure;
    
    public void measurementsChanged() {
        setChanged(); 
        /**
         * просто устанавливает флаг (true/false), что были изменения
         * без setChanged(), метод оповещения notifyObservers()
         * наблюдателей - НЕ СРАБОТАЕТ !
         * clearChanged() - сбрасывает флаг
         * hasChanged() - получает флаг
         */
        notifyObservers(); 
        /**
         * или notifyObservers(Object arg)                  
         * Object arg - данные, которые передаются
         * наблюдателям в их метод update(Observable obs, Object arg)
         */
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }    

    public float getTemp() { return temp; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}
