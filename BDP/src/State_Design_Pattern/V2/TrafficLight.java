package State_Design_Pattern.V2;

public class TrafficLight {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
    }
}
