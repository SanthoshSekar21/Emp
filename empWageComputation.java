// EmpWageComputation.java
import java.util.Scanner;

public class EmpWageComputation {

    // Constants
    private static final int FULL_TIME_WAGE_PER_HOUR = 20;  // Wage per hour for full-time employees
    private static final int PART_TIME_WAGE_PER_HOUR = 15;  // Wage per hour for part-time employees
    private static final int MAX_WORKING_HOURS = 100;        // Maximum working hours in a month
    private static final int MAX_WORKING_DAYS = 20;          // Maximum working days in a month

    // Enum for Employee Type
    private enum EmployeeType {
        FULL_TIME,
        PART_TIME
    }

    // Function to get daily work hours based on employee type
    private static int getWorkHours(EmployeeType type) {
        switch (type) {
            case FULL_TIME:
                return 8;  // Full-time work hours per day
            case PART_TIME:
                return 4;  // Part-time work hours per day
            default:
                throw new IllegalArgumentException("Invalid employee type");
        }
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

    public static void main(String[] args) {
        // Display Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

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

        // Variables to track total hours worked and days worked
        int totalHoursWorked = 0;
        int totalDaysWorked = 0;
        int dailyWorkHours = getWorkHours(type);
        int totalWage = 0;

        // Loop to simulate working days until the conditions are met
        for (int day = 1; day <= MAX_WORKING_DAYS; day++) {
            if (totalHoursWorked >= MAX_WORKING_HOURS || totalDaysWorked >= MAX_WORKING_DAYS) {
                break;
            }

            // Simulate presence for the day
            System.out.printf("Is the employee present on Day %d? (true/false): ", day);
            boolean isPresent = scanner.nextBoolean();

            if (isPresent) {
                int dailyWage = calculateDailyWage(dailyWorkHours, type);
                totalWage += dailyWage;
                totalHoursWorked += dailyWorkHours;
                totalDaysWorked++;
            }
        }

        // Display the results
        System.out.println("\nTotal Wage for the month is: $" + totalWage);
        System.out.println("Total Working Hours: " + totalHoursWorked);
        System.out.println("Total Working Days: " + totalDaysWorked);

        // Close the scanner
        scanner.close();
    }
}
