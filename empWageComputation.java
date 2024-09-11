
// EmpWageComputation.java
import java.util.Scanner;

public class EmpWageComputation {

    // Constants
    private static final int WAGE_PER_HOUR = 20;  // Example wage per hour
    private static final int TOTAL_WORKING_DAYS = 7; // Number of days in a week

    // Function to calculate wage based on hours worked
    private static int calculateWage(int hoursWorked) {
        return hoursWorked * WAGE_PER_HOUR;
    }

    // Function to calculate total hours worked based on attendance
    private static int calculateHoursWorked(boolean[] attendance) {
        int totalHours = 0;
        for (boolean present : attendance) {
            if (present) {
                totalHours += 8; // Assuming 8 hours per workday
            }
        }
        return totalHours;
    }

    public static void main(String[] args) {
        // Display Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Array to hold attendance status for each day of the week
        boolean[] attendance = new boolean[TOTAL_WORKING_DAYS];
        System.out.println("Enter attendance for each day (true for present, false for absent):");

        // Read attendance for each day
        for (int i = 0; i < TOTAL_WORKING_DAYS; i++) {
            System.out.printf("Day %d: ", i + 1);
            attendance[i] = scanner.nextBoolean();
        }

        // Calculate total hours worked based on attendance
        int hoursWorked = calculateHoursWorked(attendance);

        // Calculate and display the wage
        int totalWage = calculateWage(hoursWorked);
        System.out.println("Total Wage for the week is: $" + totalWage);

        // Close the scanner
        scanner.close();
    }
}

