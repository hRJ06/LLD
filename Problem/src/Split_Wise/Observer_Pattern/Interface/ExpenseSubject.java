package Split_Wise.Observer_Pattern.Interface;

import Split_Wise.Utility.Expense;

public interface ExpenseSubject {
    void addObserver(ExpenseObserver observer);
    void removeObserver(ExpenseObserver observer);
    void notifyExpenseAdded(Expense expense);
    void notifyExpenseUpdated(Expense expense);

}
