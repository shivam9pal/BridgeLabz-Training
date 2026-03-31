package week01.method;

import java.util.Scanner;

public class CalendarProgram {
    // month names
    static String[] months = {
        "January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December"
    };
    //days in each month
    static int[] daysInMonth = {31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31
    };

    //leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    //the number of days in a month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month)/12) - 2;
        int d0 = (1 + x + (31*m0)/12) % 7; 
        return d0;
    }

    //display the calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("\n   " + months[month-1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDayOfMonth(month, year);
        int totalDays = getDaysInMonth(month, year);
       
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        displayCalendar(month, year);

        sc.close();
    }
}

