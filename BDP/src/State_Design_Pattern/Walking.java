package State_Design_Pattern;

public class Walking implements TransportationMode{
    @Override
    public int calcETA() {
        System.out.println("Calculating walking ETA.");
        return 10;
    }

    @Override
    public String getDirection() {
        return "Direction for walking.";
    }
}
