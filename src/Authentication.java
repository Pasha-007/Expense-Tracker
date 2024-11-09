import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Authentication {
    private HashMap<String, String> users = new HashMap<String, String>();
    private Scanner scanner = new Scanner(System.in);
    private final String filePath = "src/users.txt";
    private String currentUser;

    public Authentication() {

        loadUsers();
    }

    private void loadUsers(){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 2){
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUser(String name, String password){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(name+ "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    public void Signup(){
        System.out.println("You can Signup");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        users.put(name, password);
        saveUser(name, password);
        Login();
    }
    public boolean Login() {
        System.out.println("You can Login");
        System.out.println("Enter Name: ");
        String input = scanner.nextLine();
        System.out.println("Enter Pass: ");
        String input2 = scanner.nextLine();
        if (users.containsKey(input) && users.get(input).equals(input2)) {
            System.out.println("You are logged in");
            currentUser = input;
            return true;
        } else {
            System.out.println("Invalid Username or Password");
            return false;
        }
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
