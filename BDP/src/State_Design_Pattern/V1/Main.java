package State_Design_Pattern.V1;

public class Main {
    public static void main(String[] args) {
        DirectionService service = new DirectionService(new Car());
        /* State 1 */
        service.setTransportationMode(new Walking());
        System.out.println("ETA - " + service.getETA());
        System.out.println("Direction - " + service.getDirection());

        /* State 2 */
        service.setTransportationMode(new Car());
        System.out.println("ETA - " + service.getETA());
        System.out.println("Direction - " + service.getDirection());
    }
}
