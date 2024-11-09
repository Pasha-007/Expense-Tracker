import java.util.Scanner;

public class Options {

    public static void userChoice(ExpenseManager expenseManager) {
        Scanner scanner = new Scanner(System.in); //create the instance
        while (true) {
            System.out.println("Please choose between 'Add Expense, Delete Expense, View Expense, Exit'");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("Add")) {
                System.out.println("Please enter the amount you would like to add");
                double amount = Double.parseDouble(scanner.nextLine());
                System.out.println("Please enter a description for the expense");
                String description = scanner.nextLine();
                System.out.println("Please enter the date for the expense (e.g., YYYY-MM-DD)");
                String date = scanner.nextLine();
                expenseManager.addExpense(amount, description, date);
            } else if (action.equalsIgnoreCase("Delete")) {
                System.out.println("Please enter the index of the expense you would like to delete");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                expenseManager.deleteExpense(index);
            } else if (action.equalsIgnoreCase("View")) {
                expenseManager.viewExpense();
            } else if (action.equalsIgnoreCase("Exit")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
