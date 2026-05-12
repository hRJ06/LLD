package Split_Wise.Observer_Pattern.Interface;

import Split_Wise.Utility.Expense;

public interface ExpenseObserver {
    void onExpenseAdded(Expense expense);
    void onExpenseUpdated(Expense expense);
}
