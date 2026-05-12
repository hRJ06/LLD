package Split_Wise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Split_Wise.Algorithm.BalanceSheet;
import Split_Wise.Observer_Pattern.Class.ExpenseManager;
import Split_Wise.Split_Type_Factory_Pattern.Split;
import Split_Wise.Split_Type_Factory_Pattern.SplitFactory;
import Split_Wise.Utility.Expense;
import Split_Wise.Utility.User;

public class Main {
    public static void main(String[] args) {
        User alice = new User("1", "Alice", "alice@example.com");
        User bob = new User("2", "Bob", "bob@example.com");
        User charlie = new User("3", "Charlie", "charlie@example.com");

        ExpenseManager expenseManager = new ExpenseManager();
        BalanceSheet balanceSheet = new BalanceSheet();

        expenseManager.addObserver(balanceSheet);

        List<User> participants = new ArrayList<>();
        participants.add(alice);
        participants.add(bob);
        participants.add(charlie);  

        /* ALICE - DINNER */
        Split equalSplit = SplitFactory.createSplit("EQUAL");
        Map<String, Object> splitDetail = new HashMap<>();
        Map<User, Double> dinnerShare = equalSplit.calculateSplit(60.0, participants, splitDetail);

        Expense dinnerExpense = new Expense("1", "Dinner", 60.0, alice, participants, dinnerShare);

        expenseManager.addExpense(dinnerExpense);

        /* BOB - MOVIE */
        Map<String, Object> percentageSplitDetail = new HashMap<>();
        Map<User, Double> percentage = new HashMap<>();
        percentage.put(alice, 40.0);
        percentage.put(bob, 30.0);
        percentage.put(charlie, 30.0);

        percentageSplitDetail.put("percentage", percentage);

        Split percentSplit = SplitFactory.createSplit("PERCENTAGE");
        Map<User, Double> movieShare = percentSplit.calculateSplit(45.0, participants, percentageSplitDetail);

        Expense moviExpense = new Expense("2", "Movie", 45.0, bob, participants, movieShare);

        expenseManager.addExpense(moviExpense);

        System.out.println("Individual Balance - ");
        System.out.println("Alice's - $" + balanceSheet.getTotalBalance(alice));
        System.out.println("Bob's - $" + balanceSheet.getTotalBalance(bob));
        System.out.println("Charlie's - $" + balanceSheet.getTotalBalance(charlie));

        System.out.println("\nPairwise Balance - ");
        System.out.println("Alice / Bob - $" + balanceSheet.getBalance(alice, bob));
        System.out.println("Alice / Charlie - $" + balanceSheet.getBalance(alice, charlie));
        System.out.println("Bob / Charlie - $" + balanceSheet.getBalance(bob, charlie));

        System.out.println("OPTIMAL MINIMUM SETTLEMENT");
        int optimalSettlements = balanceSheet.getMinimumSettlement();
        System.out.println(optimalSettlements);

    }
}
