//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.text.html.Option;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;

        Authentication auth = new Authentication();

        while(true) {
            System.out.println("Login or Signup");
            action = scanner.nextLine();
            if(action.equalsIgnoreCase("Login")){
                auth.Login();
                Options.userChoice();
                break;
            } else if (action.equalsIgnoreCase("Signup")) {
                auth.Signup();
                break;
            }else {
                System.out.println("Invalid choice. Please type 'Login' or 'Signup.'");
            }
        }
        scanner.close();
    }
}