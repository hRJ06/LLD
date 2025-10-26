package State_Design_Pattern.V2;

public class GreenLightState implements TrafficLightState{
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from GREEN to YELLOW.");
        context.setState(new YellowLightState());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}
