package Builder;

public class Car {
    private final String engine;
    private final int wheels;
    private final int seats;
    private final String color;
    private final boolean sunRoof;
    private final boolean navigationSystem;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.seats = builder.seats;
        this.color = builder.color;
        this.sunRoof = builder.sunRoof;
        this.navigationSystem = builder.navigationSystem;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public boolean hasSunRoof() {
        return sunRoof;
    }

    public boolean hasNavigationSystem() {
        return navigationSystem;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", seats=" + seats
                + ", color=" + color + ", sunroof=" + sunRoof
                + ", navigationSystem=" + navigationSystem + "]";
    }


    public static class CarBuilder {
        private String engine;
        private int wheels = 4;
        private int seats = 5;
        private String color = "Black";
        private boolean sunRoof = false;
        private boolean navigationSystem = false;

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setSunRoof(boolean isSunRoof) {
            this.sunRoof = isSunRoof;
            return this;
        }

        public CarBuilder setNavigationSystem(boolean isNavigationSystem) {
            this.navigationSystem = isNavigationSystem;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}


