/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.Scanner;
public class C3E27PointsInTriangle {
    public static void main(String[] args){
        System.out.println("This program determines if a set of points are in a triangle");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a point's x- and y-coordinates seperated by a space ");
        double x = input.nextDouble();
        double y = input.nextDouble();
        input.close();
        
        double xIntersect = (-x * (200 * 100)) / (-y * 200 - x * 100);
        double yIntersect = (-y * (200 * 100)) / (-y * 200 - x * 100);
        
        if (x > xIntersect || y > yIntersect){
            System.out.println("The point is not in the triangle");    
        } else {
            System.out.println("The point is in the triangle"); 
        }
        
    }
}
