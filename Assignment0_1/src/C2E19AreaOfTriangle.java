/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * This program will display the distance between two points
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.Scanner;
public class C2E19AreaOfTriangle {
    public static void main(String[] args){
        System.out.println("This program will display the area of a triangle given 3 points on a coordinate plane.");
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
        System.out.println("Your value for y1 is:" + y1);
        System.out.println("Your value for x2 is:" + x2);
        System.out.println("Your value for y2 is:" + y2);
        System.out.println("Your value for x3 is:" + x3);
        System.out.println("Your value for y3 is:" + y3);

        //s = (side1 + side2 + side3)/2;
        double side1 = Math.pow(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2), 0.5);
        double side2 = Math.pow(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2), 0.5);
        double side3 = Math.pow(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2), 0.5);
        double s = (side1 + side2 + side3)/2;
        double area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
        System.out.println("The area of this triangle is: "  + area);
    }
}
