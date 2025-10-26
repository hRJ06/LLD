package State_Design_Pattern.V1;

public class Car implements TransportationMode{
    @Override
    public int calcETA() {
        System.out.println("Calculating car ETA.");
        return 7;
    }

    @Override
    public String getDirection() {
        return "Direction for car.";
    }
}
