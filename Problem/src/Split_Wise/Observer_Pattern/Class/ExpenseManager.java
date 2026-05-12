package Split_Wise.Observer_Pattern.Class;

import java.util.ArrayList;
import java.util.List;

import Split_Wise.Observer_Pattern.Interface.ExpenseObserver;
import Split_Wise.Observer_Pattern.Interface.ExpenseSubject;
import Split_Wise.Utility.Expense;

public class ExpenseManager implements ExpenseSubject {
    private List<ExpenseObserver> observers = new ArrayList<>();
    private List<Expense> expenses = new ArrayList<>();

    @Override
    public void addObserver(ExpenseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ExpenseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyExpenseAdded(Expense expense) {
        for(ExpenseObserver observer : observers) {
            observer.onExpenseAdded(expense);
        }
    }

    @Override
    public void notifyExpenseUpdated(Expense expense) {
        for(ExpenseObserver observer : observers) {
            observer.onExpenseUpdated(expense);
        }
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        notifyExpenseUpdated(expense);
    }

    public void updateExpense(Expense expense) {
        for(int i = 0; i<expenses.size(); i++) {
            if(expenses.get(i).getId().equals(expense.getId())) {
                expenses.set(i, expense);
                notifyExpenseUpdated(expense);
                break;
            }
        }
        throw new IllegalArgumentException("Expense with ID - " + expense.getId() + " not found.");
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }
}
