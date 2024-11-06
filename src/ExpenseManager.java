import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpenseManager {
    private HashMap<String, List<Expense>> userExpenses;
    public ExpenseManager(){
        userExpenses = new HashMap<>();
    }
    public void addExpense(String user, double amount, String description, String date) {
        Expense expense = new Expense(amount, description, date);
        userExpenses.computeIfAbsent(user, k -> new ArrayList<>()).add(expense);
        System.out.println("Expense added: " + expense);
    }
}
