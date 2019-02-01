/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.Scanner;
public class C3E3LinearEquations {
    public static void main(String[] args){
        System.out.println("This program displays the intersection of two linear equations.");
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a, b, c, d, e, f points seperated by spaces: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        input.close();
        System.out.println("The value of a is: " + a);
        System.out.println("The value of a is: " + b);
        System.out.println("The value of a is: " + c);
        System.out.println("The value of a is: " + d);
        System.out.println("The value of a is: " + e);
        System.out.println("The value of a is: " + f);
        System.out.println("The resulting first equation would be " + a + "x + " + b + "y = " + e);
        System.out.println("The resulting second equation would be " + c + "x + " + d + "y = " + f);


        if((a*d) - (b*c) == 0) {
           System.out.println("The equation has no solution");
        } else {
           double x = (e*d - b*f)/(a*d - b*c);
           double y = (a*f - e*c)/(a*d - b*c);
           System.out.println("The value of x is: " + x + " and y is: " + y);
        }
    }
}
