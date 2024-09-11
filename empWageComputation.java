// EmpWageComputation.java
import java.util.Scanner;

public class EmpWageComputation {

    // Constants
    private static final int WAGE_PER_HOUR = 20;  // Example wage per hour
    private static final int DAILY_WORK_HOURS = 8; // Hours worked per day

    // Function to calculate daily wage
    private static int calculateDailyWage(int hoursWorked) {
        return hoursWorked * WAGE_PER_HOUR;
    }

    // Function to calculate total weekly wage based on attendance
    private static int calculateWeeklyWage(boolean[] attendance) {
        int totalWage = 0;
        for (boolean present : attendance) {
            if (present) {
                totalWage += calculateDailyWage(DAILY_WORK_HOURS);
            }
        }
        return totalWage;
    }

    public static void main(String[] args) {
        // Display Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Array to hold attendance status for each day of the week
        boolean[] attendance = new boolean[7]; // 7 days in a week
        System.out.println("Enter attendance for each day (true for present, false for absent):");

        // Read attendance for each day
        for (int i = 0; i < attendance.length; i++) {
            System.out.printf("Day %d: ", i + 1);
            attendance[i] = scanner.nextBoolean();
        }

        // Calculate and display the daily wage for each day
        System.out.println("\nDaily Wage Breakdown:");
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                System.out.printf("Day %d: $%d\n", i + 1, calculateDailyWage(DAILY_WORK_HOURS));
            } else {
                System.out.printf("Day %d: Absent\n", i + 1);
            }
        }

        // Calculate and display the total weekly wage
        int weeklyWage = calculateWeeklyWage(attendance);
        System.out.println("\nTotal Wage for the week is: $" + weeklyWage);

        // Close the scanner
        scanner.close();
    }
}


