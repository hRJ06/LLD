package State_Design_Pattern.V1;

public class DirectionService {
    private TransportationMode mode;
    public DirectionService(TransportationMode mode) {
        this.mode = mode;
    }
    public void setTransportationMode(TransportationMode mode) {
        this.mode = mode;
    }
    public int getETA() {
        return mode.calcETA();
    }
    public String getDirection() {
        return mode.getDirection();
    }
}
