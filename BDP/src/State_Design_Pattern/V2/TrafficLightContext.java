package State_Design_Pattern.V2;

public class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext() {
        this.state = new RedLightState();
    }
    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public void getColor() {
        state.getColor();;
    }
}
