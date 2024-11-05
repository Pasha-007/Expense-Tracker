import java.util.Scanner;

public class Options {

    public static void userChoice(){
        Scanner scanner = new Scanner(System.in); //create the instance
        System.out.println("Please choose between 'Add Expense, Delete Expense, View Expense'");
        String action = scanner.nextLine();
        if(action.equals("Add Expense")){
            System.out.println("Please enter the amount you would like to add");
        }else if(action.equals("Delete Expense")){
            System.out.println("Please enter the amount you would like to delete");
        }else if(action.equals("View Expense")){
            System.out.println("Please enter the amount you would like to view");
        }
    }
}
