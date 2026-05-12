package Split_Wise.Utility;

import java.util.List;
import java.util.Map;

public class Expense {
    private String id;
    private String description;
    private double amount;
    private User payer;
    private List<User> participant;
    private Map<User, Double> share;

    public Expense(String id, String description, double amount, User payer, List<User> participant, Map<User, Double> share) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.payer = payer;
        this.participant = participant;
        this.share = share;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public User getPayer() {
        return payer;
    }

    public List<User> getParticipant() {
        return participant;
    }

    public Map<User, Double> getShare() {
        return share;
    }
}
