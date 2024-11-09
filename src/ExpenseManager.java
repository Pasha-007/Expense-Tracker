import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpenseManager {
    private HashMap<String, List<Expense>> userExpenses;
    private List<Expense> expenses;
    private String currentUser;
    private final String filePath = "src/expenses.txt";

    public ExpenseManager(String currentUser) {
        this.currentUser = currentUser;
        expenses = new ArrayList<>();
        loadExpenses();
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
        loadExpenses();
    }

    public void addExpense(double amount, String description, String date) {
        Expense expense = new Expense(amount, description, date);
        expenses.add(expense);
        saveExpenses();
        System.out.println("Expense added: " + expense);
    }


    public void deleteExpense(int index) {
        if (index >= 0 && index < expenses.size()){
            Expense removed = expenses.remove(index);
            System.out.println("Expense removed: " + removed);
        }else {
            System.out.println("Invalid index. No expense deleted.");
        }
    }
    public void viewExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expense found.");
        } else {
            System.out.println("Here are your expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i+1) + ". " + expenses.get(i));
            }
        }
    }
    public void loadExpenses() {
        expenses.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(currentUser)) {
                    double amount = Double.parseDouble(parts[1]);
                    String description = parts[2];
                    String date = parts[3];
                    expenses.add(new Expense(amount, description, date));
                }
            }
        } catch (IOException e) {
            System.out.println("Error while loading expenses.txt");
        }
    }
    public void saveExpenses() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : getAllExpensesFromFile()){
                writer.write(line);
                writer.newLine();
            }
            for (Expense expense : expenses) {
                writer.write(currentUser + "," + expense.getAmount() + "," + expense.getDescription() + "," + expense.getDate());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<String> getAllExpensesFromFile() {
        List<String> allExpenses = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 4 && !parts[0].equals(currentUser)) {
                    allExpenses.add(line);
                }
            }
        }catch (IOException e){
            System.out.println("Error while loading expenses.txt");
        }
        return allExpenses;
    }
}
