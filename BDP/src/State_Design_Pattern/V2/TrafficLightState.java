package State_Design_Pattern.V2;

public interface TrafficLightState {
    void next(TrafficLightContext context);
    String getColor();
}
