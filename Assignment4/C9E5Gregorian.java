/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 *
 */
import java.time.Month;
import java.util.GregorianCalendar;
public class C9E5Gregorian {
    public static void main(String[] args) {
        System.out.println("This program is to test the Gregorian API");

        GregorianCalendar newCalendar = new GregorianCalendar();
        String currentDate = Current(newCalendar);
        System.out.println(currentDate);
        String specificDate = specificDate(newCalendar);
        System.out.println(specificDate);

    }
    public static String Current (GregorianCalendar calendar){
        System.out.print("Current year, month, and day in format Month/Day/Year: ");
        int Month = calendar.get(calendar.MONTH) + 1;
        String currentDate = Month + "/" + calendar.get(calendar.DAY_OF_MONTH) + "/"  + calendar.get(calendar.YEAR);
        return currentDate;
    }
    public static String specificDate (GregorianCalendar calendar) {
        System.out.print("Elapsed time since January 1, 1970 set to 1234567898765L in format Month/Day/Year: ");
        calendar.setTimeInMillis(1234567898765L);
        String currentDate = calendar.get(calendar.MONTH) + "/" + calendar.get(calendar.DAY_OF_MONTH) + "/"  + calendar.get(calendar.YEAR);
        return currentDate;
    }
}