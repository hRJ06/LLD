package State_Design_Pattern.V2;

public class RedLightState implements TrafficLightState{
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from RED to GREEN.");
        context.setState(new GreenLightState());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}
