// EmpWageComputation.java
import java.util.Scanner;

public class EmpWageComputation {

    // Constants
    private static final int FULL_TIME_WAGE_PER_HOUR = 20;  // Wage per hour for full-time employees
    private static final int PART_TIME_WAGE_PER_HOUR = 15;  // Wage per hour for part-time employees
    private static final int FULL_TIME_WORK_HOURS = 8;       // Full-time work hours per day
    private static final int PART_TIME_WORK_HOURS = 4;       // Part-time work hours per day

    // Function to calculate daily wage
    private static int calculateDailyWage(int hoursWorked, boolean isFullTime) {
        int wagePerHour = isFullTime ? FULL_TIME_WAGE_PER_HOUR : PART_TIME_WAGE_PER_HOUR;
        return hoursWorked * wagePerHour;
    }

    // Function to calculate total weekly wage based on attendance
    private static int calculateWeeklyWage(boolean[] attendance, boolean isFullTime) {
        int totalWage = 0;
        int dailyWorkHours = isFullTime ? FULL_TIME_WORK_HOURS : PART_TIME_WORK_HOURS;
        for (boolean present : attendance) {
            if (present) {
                totalWage += calculateDailyWage(dailyWorkHours, isFullTime);
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

        // Read employee type
        System.out.println("Is the employee full-time? (true/false):");
        boolean isFullTime = scanner.nextBoolean();

        // Display daily wage for each day
        System.out.println("\nDaily Wage Breakdown:");
        int dailyWorkHours = isFullTime ? FULL_TIME_WORK_HOURS : PART_TIME_WORK_HOURS;
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                System.out.printf("Day %d: $%d\n", i + 1, calculateDailyWage(dailyWorkHours, isFullTime));
            } else {
                System.out.printf("Day %d: Absent\n", i + 1);
            }
        }

        // Calculate and display the total weekly wage
        int weeklyWage = calculateWeeklyWage(attendance, isFullTime);
        System.out.println("\nTotal Wage for the week is: $" + weeklyWage);

        // Close the scanner
        scanner.close();
    }
}


