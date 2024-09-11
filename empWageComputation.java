// EmpWageComputation.java
import java.util.Scanner;

public class EmpWageComputation {

    // Constants
    private static final int WAGE_PER_HOUR = 20;  // Example wage per hour

    // Function to calculate wage
    private static int calculateWage(int hoursWorked) {
        return hoursWorked * WAGE_PER_HOUR;
    }

    public static void main(String[] args) {
        // Display Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Read hours worked from user
        System.out.print("Enter hours worked in a week: ");
        int hoursWorked = scanner.nextInt();

        // Validate input
        if (hoursWorked < 0) {
            System.out.println("Error: Hours worked cannot be negative.");
            scanner.close();
            return;
        }

        // Calculate and display the wage
        int totalWage = calculateWage(hoursWorked);
        System.out.println("Total Wage for " + hoursWorked + " hours is: $" + totalWage);

        // Close the scanner
        scanner.close();
    }

