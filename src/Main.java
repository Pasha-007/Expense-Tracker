
import javax.swing.text.html.Option;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;

        Authentication auth = new Authentication();
        ExpenseManager expenseManager = new ExpenseManager(auth.getCurrentUser());

        while (true) {
            System.out.println("Login or Signup");
            action = scanner.nextLine();
            if (action.equalsIgnoreCase("Login")) {
                if (auth.Login()) {
                    expenseManager.setCurrentUser(auth.getCurrentUser());
                    Options.userChoice(expenseManager);
                }
                break;
            } else if (action.equalsIgnoreCase("Signup")) {
                auth.Signup();
                expenseManager   = new ExpenseManager(auth.getCurrentUser());
                Options.userChoice(expenseManager);
                break;
            } else {
                System.out.println("Invalid choice. Please type 'Login' or 'Signup.'");
            }
        }
        scanner.close();
    }
}