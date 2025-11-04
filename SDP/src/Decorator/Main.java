package Decorator;

import Decorator.Coffee_Decorator.Concrete_Decorator.MilkDecorator;
import Decorator.Coffee_Decorator.Concrete_Decorator.SugarDecorator;
import Decorator.Concrete_Coffee.Expresso;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Expresso();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println("Order - " + coffee.getDescription());
        System.out.println("Total Cost - $" + coffee.getCost());
    }

}
