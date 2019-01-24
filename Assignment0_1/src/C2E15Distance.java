/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * This program will display the distance between two points
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.Scanner;
public class C2E15Distance {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter x1 and y1");
        double x1 = input.nextDouble();
        System.out.println("Your value for x1 is:" + x1);
        double y1 = input.nextDouble();
        System.out.println("Your value for y1 is:" + y1);
        System.out.println("Please enter x2 and y2");
        double x2 = input.nextDouble();
        System.out.println("Your value for x1 is:" + x2);
        double y2 = input.nextDouble();
        System.out.println("Your value for y1 is:" + y2);
        input.close();
        
        double allPoints = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
        double distance = Math.pow(allPoints, 0.5);
        System.out.println("The distance between two points is: "  + distance);
        
    }
}
