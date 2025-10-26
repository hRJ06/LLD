package State_Design_Pattern.V2;

public class YellowLightState implements TrafficLightState{
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from YELLOW to RED.");
        context.setState(new RedLightState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}
