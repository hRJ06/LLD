package Split_Wise.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Split_Wise.Observer_Pattern.Interface.ExpenseObserver;
import Split_Wise.Utility.Expense;
import Split_Wise.Utility.User;
import Split_Wise.Utility.UserPair;

public class BalanceSheet implements ExpenseObserver{

    private Map<UserPair, Double> balances = new HashMap<>();

    @Override
    public void onExpenseAdded(Expense expense) {
        updateBalance(expense);
    }

    @Override
    public void onExpenseUpdated(Expense expense) {
        updateBalance(expense);
    }

    private void updateBalance(Expense expense) {
        User payer = expense.getPayer();
        Map<User, Double> share = expense.getShare();
        for(Map.Entry<User, Double> entry : share.entrySet()) {
            User participant = entry.getKey();
            Double amount = entry.getValue();
            if(!participant.equals(payer)) {
                UserPair userPair = new UserPair(participant, payer);
                double currentBalance = balances.getOrDefault(userPair, 0.0);
                balances.put(userPair, currentBalance + amount);
            }
        }
    }

    public double getBalance(User user1, User user2) {
        UserPair pair1 = new UserPair(user1, user2);
        UserPair pair2 = new UserPair(user2, user1);
        double balance1 = balances.getOrDefault(pair1, 0.0);
        double balance2 = balances.getOrDefault(pair2, 0.0);
        return balance2 - balance1;
    }

    public double getTotalBalance(User user) {
        double total = 0.0;
        for(Map.Entry<UserPair, Double> entry : balances.entrySet()) {
            UserPair pair = entry.getKey();
            Double amount = entry.getValue();
            if(pair.getUser1().equals(user)) {
                total -= amount;
            } else if(pair.getUser2().equals(user)) {
                total += amount;
            }
        }
        return total;
    }

    public int getMinimumSettlement() {
        Map<User, Double> netBalance = new HashMap<>();
        for(Map.Entry<UserPair, Double> entry : balances.entrySet()) {
            UserPair pair = entry.getKey();
            double amount = entry.getValue();
            User debtor = pair.getUser1();
            User creditor = pair.getUser2();
            netBalance.put(debtor, netBalance.getOrDefault(debtor, 0.0) - amount);
            netBalance.put(creditor, netBalance.getOrDefault(creditor, 0.0) + amount);
        } 
        List<Double> creditList = new ArrayList<>();
        for(Map.Entry<User, Double> entry : netBalance.entrySet()) {
            if(Math.abs(entry.getValue()) > 0.001) {
                creditList.add(entry.getValue());
            }
        }
        int n = creditList.size();
        return DFS(0, creditList, n);
    }

    private int DFS(int curIndex, List<Double> creditList, int n) {
        while(curIndex < n && creditList.get(curIndex) == 0) {
            curIndex++;
        }
        if(curIndex >= n) return 0;
        int ans = Integer.MAX_VALUE;
        for(int nextIndex = curIndex + 1; nextIndex<n; nextIndex++) {
            if(creditList.get(curIndex) * creditList.get(nextIndex) < 0) {
                creditList.set(nextIndex, creditList.get(curIndex) + creditList.get(nextIndex));
                ans = Math.min(ans, 1 + DFS(curIndex + 1, creditList, n));
                creditList.set(nextIndex, creditList.get(curIndex) - creditList.get(nextIndex));
            }
        }
        return ans;
    }
}
