package dayfinder;

import java.time.LocalDate;

/**
 * finding the Day by getting the date 
 * 
 * @author AJAISHARMA D
 * @version 1.0  07-09-2022
 */
public class DayFinder {

    /**
     * finds the day by Calender method
     *
     * @param day, month, year
     * @return day
     */
    public static String findDay(int date, int month, int year) {
        LocalDate day = LocalDate.of(year, month, date);
        return day.getDayOfWeek().toString();
    }
}