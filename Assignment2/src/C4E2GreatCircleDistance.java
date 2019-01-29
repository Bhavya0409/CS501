/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.Scanner;
public class C4E2GreatCircleDistance {
    public static void main(String[] args){
        System.out.println("This program determines the great circle distance, which is the distance between two points on the surface of a sphere.");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter point 1 (latitude and longitude) in degrees ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.print("Enter point 2 (latitude and longitude) in degrees ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        input.close();
        System.out.println("Point 1 x-coordinate is: " + x1 + " and y-coordinate is: "  + y1);
        System.out.println("Point 2 x-coordinate is: " + x2 + " and y-coordinate is: "  + y2);
        
        double distance = 6371.01 * Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) + 
                Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1) - Math.toRadians(y2)));
        System.out.println("The distance between the two points is " + distance + " km");
        
    }
}
