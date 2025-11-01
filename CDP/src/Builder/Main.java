package Builder;

public class Main {
    public static void main(String[] args) {
        Car.CarBuilder builder = new Car.CarBuilder();
        Car car = builder.setEngine("V8")
                .setColor("Red")
                .setSeats(5)
                .setSunRoof(true)
                .build();

        System.out.println(car);
    }
}
