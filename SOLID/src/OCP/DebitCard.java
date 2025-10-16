package OCP;

public class DebitCard implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Debit Card payment - " + amount);
    }
}
