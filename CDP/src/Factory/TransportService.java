package Factory;

public class TransportService {
    public static void main(String[] args) {
        Transport vehicle = TransportFactory.createTransport("car");
        vehicle.deliver();
    }
}
