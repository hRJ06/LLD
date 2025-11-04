package Decorator.Concrete_Coffee;

import Decorator.Coffee;

public class Expresso implements Coffee{
    @Override
    public double getCost() {
        return 2.00;
    }

    @Override
    public String getDescription() {
        return "Expresso";
    }

}
