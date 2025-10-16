package Observer_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    private float temperature;
    private final List<Observer> observerList;

    public WeatherStation() {
        this.observerList = new ArrayList<>();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observerList) {
            observer.update(temperature);
        }
    }
}
