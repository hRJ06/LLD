package Observer_Design_Pattern;

public class WeatherStationApplication {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Observer mobile = new MobileDevice("Mobile");
        Observer watch = new WatchDevice("Watch");

        weatherStation.addObserver(mobile);
        weatherStation.addObserver(watch);

        weatherStation.setTemperature(25);

        weatherStation.removeObserver(watch);

        weatherStation.setTemperature(26);
    }
}
