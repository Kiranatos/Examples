package pattern.observer.ex2_weatherdata;

public interface Observer {
    public void update(float temp, float humidity, float pressure);
}

