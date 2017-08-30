package pattern.observer.ex2_weatherdata;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private Subject weatherData;
    private float temp;
    private float humidity;
    
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current condition: " + temp + "F degrees and " + humidity + "% humidity");
    }
    
}
