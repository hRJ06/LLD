package State_Design_Pattern.V1;

public class Cycling implements TransportationMode{
    @Override
    public int calcETA() {
        System.out.println("Calculating cycling ETA.");
        return 9;
    }

    @Override
    public String getDirection() {
        return "Direction for Cycle.";
    }
}
