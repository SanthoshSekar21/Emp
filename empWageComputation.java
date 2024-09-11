// EmpWageComputation.java
import java.util.Scanner;

public class EmpWageComputation {

    // Constants
    private static final int FULL_TIME_WAGE_PER_HOUR = 20;  // Wage per hour for full-time employees
    private static final int PART_TIME_WAGE_PER_HOUR = 15;  // Wage per hour for part-time employees
    private static final int FULL_TIME_WORK_HOURS = 8;       // Full-time work hours per day
    private static final int PART_TIME_WORK_HOURS = 4;       // Part-time work hours per day
    private static final int WORKING_DAYS_PER_MONTH = 20;    // Number of working days in a month

    // Enum for Employee Type
    private enum EmployeeType {
        FULL_TIME,
        PART_TIME
    }

    // Function to calculate daily wage
    private static int calculateDailyWage(int hoursWorked, EmployeeType type) {
        int wagePerHour;
        switch (type) {
            case FULL_TIME:
                wagePerHour = FULL_TIME_WAGE_PER_HOUR;
                break;
            case PART_TIME:
                wagePerHour = PART_TIME_WAGE_PER_HOUR;
                break;
            default:
                throw new IllegalArgumentException("Invalid employee type");
        }
        return hoursWorked * wagePerHour;
    }

    // Function to calculate monthly wage based on attendance
    private static int calculateMonthlyWage(boolean[] attendance, EmployeeType type) {
        int totalWage = 0;
        int dailyWorkHours;
        switch (type) {
            case FULL_TIME:
                dailyWorkHours = FULL_TIME_WORK_HOURS;
                break;
            case PART_TIME:
                dailyWorkHours = PART_TIME_WORK_HOURS;
                break;
            default:
                throw new IllegalArgumentException("Invalid employee type");
        }
        for (boolean present : attendance) {
            if (present) {
                totalWage += calculateDailyWage(dailyWorkHours, type);
            }
        }
        return totalWage;
    }

    public static void main(String[] args) {
        // Display Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Array to hold attendance status for each working day of the month
        boolean[] attendance = new boolean[WORKING_DAYS_PER_MONTH];
        System.out.println("Enter attendance for each working day (true for present, false for absent):");

        // Read attendance for each working day
        for (int i = 0; i < attendance.length; i++) {
            System.out.printf("Day %d: ", i + 1);
            attendance[i] = scanner.nextBoolean();
        }

        // Read employee type
        System.out.println("Enter employee type (1 for Full-Time, 2 for Part-Time):");
        int typeInput = scanner.nextInt();
        EmployeeType type;
        switch (typeInput) {
            case 1:
                type = EmployeeType.FULL_TIME;
                break;
            case 2:
                type = EmployeeType.PART_TIME;
                break;
            default:
                System.out.println("Invalid input for employee type.");
                scanner.close();
                return;
        }

        // Display daily wage for each working day
        System.out.println("\nDaily Wage Breakdown:");
        int dailyWorkHours = (type == EmployeeType.FULL_TIME) ? FULL_TIME_WORK_HOURS : PART_TIME_WORK_HOURS;
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                System.out.printf("Day %d: $%d\n", i + 1, calculateDailyWage(dailyWorkHours, type));
            } else {
                System.out.printf("Day %d: Absent\n", i + 1);
            }
        }

        // Calculate and display the total monthly wage
        int monthlyWage = calculateMonthlyWage(attendance, type);
        System.out.println("\nTotal Wage for the month is: $" + monthlyWage);

        // Close the scanner
        scanner.close();
    }
}
