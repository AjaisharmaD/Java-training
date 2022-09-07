package dayfinder;

import java.util.Scanner;

import dayfinder.DayFinder;

/**
 * getting the input for finding the day
 *
 * @author AJAISHARMA D
 * @version 1.0  07-09-2022
 */
public class DateController {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        DayFinder dayFinder = new DayFinder();
        System.out.println("Enter the Date: ");
        int date = scanner.nextInt();
        System.out.println("Enter the Month: ");
        int month = scanner.nextInt();
        System.out.println("Enter the Year: ");
        int year = scanner.nextInt();

        String dayOfWeek = dayFinder.findDay(date, month, year); 
        System.out.println("Day of the week is: " + dayOfWeek);       
    }
}