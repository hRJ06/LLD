package Decorator.Concrete_Coffee;

import Decorator.Coffee;

public class Cappuccino implements Coffee {
    @Override
    public double getCost() {
        return 5.00;
    }

    @Override
    public String getDescription() {
        return "Cappuccino";
    }

}
