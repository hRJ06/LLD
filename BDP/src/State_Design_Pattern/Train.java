package State_Design_Pattern;

public class Train implements TransportationMode{
    @Override
    public int calcETA() {
        System.out.println("Calculating Train ETA.");
        return 5;
    }

    @Override
    public String getDirection() {
        return "Direction for Train.";
    }
}
