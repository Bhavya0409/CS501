/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * This program will display the distance between two points
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.Scanner;
public class C2E19AreaOfTriangle {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the coordinates of three points separated by spaces like x1 y1 x2 y2 x3 y3: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        input.close();
        System.out.println("Your value for x1 is:" + x1);
        System.out.println("Your value for x1 is:" + y1);
        System.out.println("Your value for x1 is:" + x2);
        System.out.println("Your value for x1 is:" + y2);
        System.out.println("Your value for x1 is:" + x3);
        System.out.println("Your value for x1 is:" + y3);
        
        double allPoints = x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2);
        double areaOfTriangle = Math.abs(allPoints / 2);
        System.out.println("The area of this triangle is: "  + areaOfTriangle);        
    }
}
