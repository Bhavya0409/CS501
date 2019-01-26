/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
public class C1E12AverageSpeed {

    public static void main(String[] args){
        System.out.println("This program will calculate the speed of a runner in km/h given miles ran in a certain time.");
        double milesToKilometer = (24 * 1.6);
        double totalHours = (40.00 / 60.00) + (35.00 / 3600.00) + 1.0;
        double averageSpeed = milesToKilometer / totalHours;
        System.out.println("Average speed is: " + averageSpeed + " km/h");
    }
}
