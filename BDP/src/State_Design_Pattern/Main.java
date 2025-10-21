package State_Design_Pattern;

public class Main {
    public static void main(String[] args) {
        DirectionService service = new DirectionService(new Car());
        service.setTransportationMode(new Walking());
        System.out.println("ETA - " + service.getETA());
        System.out.println("Direction - " + service.getDirection());
    }
}
