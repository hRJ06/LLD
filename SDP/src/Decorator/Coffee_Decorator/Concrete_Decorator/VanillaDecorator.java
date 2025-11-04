package Decorator.Coffee_Decorator.Concrete_Decorator;

import Decorator.Coffee;
import Decorator.Coffee_Decorator.CoffeeDecorator;

public class VanillaDecorator extends CoffeeDecorator{
    public VanillaDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.75;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Vanilla";
    }
}
