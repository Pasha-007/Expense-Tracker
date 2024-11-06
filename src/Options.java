import java.util.Scanner;

public class Options {

    public static void userChoice(){
        Scanner scanner = new Scanner(System.in); //create the instance
        while(true){
            System.out.println("Please choose between 'Add Expense, Delete Expense, View Expense'");
            String action = scanner.nextLine();
            if(action.equals("Add")){
                System.out.println("Please enter the amount you would like to add");
            }else if(action.equals("Delete")){
                System.out.println("Please enter the amount you would like to delete");
            }else if(action.equals("View")){
                System.out.println("Please enter the amount you would like to view");
            }else if(action.equals("Exit")){
                break;
            }else{
                System.out.println("Invalid input");
            }
        }
    }
}
