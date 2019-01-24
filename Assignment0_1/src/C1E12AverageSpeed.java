/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * This program will display average speed in kilometers per hour
 * I pledge that I have abided by the Stevens Honor System
 */
public class C1E12AverageSpeed {
    
    public static void main(String[] args){
        double milesToKilometer = (24 * 1.6);
        double totalHours = (40.00 / 60.00) + (35.00 / 3600.00) + 1.0;
        double averageSpeed = milesToKilometer / totalHours;
        System.out.println("Average speed is: " + averageSpeed + " km/h");
    }
}
