package pattern.observer.ex2_weatherdata;

public class OtherDisplay implements Observer {
    private Subject weatherData;
    private float temp, pressure;
    
    public OtherDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.pressure = pressure;
        System.out.println("T = " + temp + " P = " + pressure);
    }
}
