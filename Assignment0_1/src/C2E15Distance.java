/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.Scanner;
public class C2E15Distance {
    public static void main(String[] args){
        System.out.println("This program will calculate the distance between the two points.");
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter x1 and y1, separated by spaces");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.println("your x1 value is: " + x1);
        System.out.println("your y1 value is: " + y1);

        System.out.println("Please enter x2 and y2, separated by spaces");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        System.out.println("your x1 value is: " + x2);
        System.out.println("your y1 value is: " + y2);
        input.close();

        double allPoints = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
        double distance = Math.pow(allPoints, 0.5);
        System.out.println("The distance between two points is: "  + distance);
        
    }
}
