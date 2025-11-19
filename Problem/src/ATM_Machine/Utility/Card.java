package ATM_Machine.Utility;

import java.util.Objects;

public class Card {
    private final String accountNumber;
    private int pin;
    private final String cardNumber;

    public Card(String accountNumber, int pin, String cardNumber) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean validatePin(int pin) {
        return Objects.equals(this.pin, pin);
    }
}
