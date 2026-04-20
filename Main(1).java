import java.util.Scanner;
import java.util.regex.Pattern;

public class Main
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variables to store "registered" data
        String registeredUsername = "";
        String registeredPassword = "";

        // --- REGISTRATION PHASE ---
        System.out.println("USER REGISTRATION");
        
        // USERNAME 
        while (true) {
            System.out.print("Enter Username: ");
            String username = input.nextLine();
            if (isValidUsername(username)) {
                registeredUsername = username;
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted. Must contain '_' and be max 5 chars.");
            }
        }

        // PASSWORD 
        while (true) {
            System.out.print("Enter Password: ");
            String password = input.nextLine();
            if (isValidPassword(password)) {
                registeredPassword = password;
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password invalid. (8+ chars, Uppercase, Number, Special char).");
            }
        }

        // CELL NUMBER (Optional for login, but part of your registration)
        System.out.print("Enter South African Cell Number: ");
        String cellNumber = input.nextLine();
        if (isValidSACellNumber(cellNumber)) {
            System.out.println("Cell phone number successfully captured.");
        }

        System.out.println("\nRegistration Complete! Now please log in.\n");

        // --- LOGIN PHASE ---
        System.out.println("LOGIN SYSTEM ");
        
        System.out.print("Enter Username: ");
        String loginUser = input.nextLine();
        
        System.out.print("Enter Password: ");
        String loginPass = input.nextLine();

        // Check if login details match registered details
        if (loginUser.equals(registeredUsername) && loginPass.equals(registeredPassword)) {
            System.out.println("Welcome " + registeredUsername + ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

        input.close();
    }

    //  VALIDATION METHODS

    public static boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public static boolean isValidPassword(String password) {
        // Regex: 8 chars, 1 Uppercase, 1 Digit, 1 Special Char
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

    public static boolean isValidSACellNumber(String cellNumber) {
        // Regex: Starts with +27 or 0, followed by 6,7, or 8, then 8 digits
        String saRegex = "^(\\+27|0)[6-8][0-9]{8}$";
        return Pattern.matches(saRegex, cellNumber);
    }
}