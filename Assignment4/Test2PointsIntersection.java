/**
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 9 exercise 11/12 Test class
 */
import java.util.*;

public class Test2PointsIntersection {

	private static boolean next = true;

	public static void main(String args[]) {
		System.out.println("This program solves a system of linear equations given two points.");
		Scanner input = new Scanner(System.in);
		while(next) {
			System.out.println("Given a line with two points (X1, Y1) and (X2, Y2)...");
			System.out.println("Enter your value for X1.");
			String x1 = input.nextLine();
			while (x1.trim().length() == 0) {
				System.out.println("Please enter a value for \"x1\".");
				x1 = input.nextLine();
			}
			System.out.println("Enter your value for Y1.");
			String y1 = input.nextLine();
			while (y1.trim().length() == 0) {
				System.out.println("Please enter a value for \"y1\".");
				y1 = input.nextLine();
			}

			System.out.println("Enter your value for X2.");
			String x2 = input.nextLine();
			while (x2.trim().length() == 0) {
				System.out.println("Please enter a value for \"x2\".");
				x2 = input.nextLine();
			}
			System.out.println("Enter your value for Y2.");
			String y2 = input.nextLine();
			while (y2.trim().length() == 0) {
				System.out.println("Please enter a value for \"y2\".");
				y2 = input.nextLine();
			}

			System.out.println("Given another line with two points (X3, Y3) and (X4, Y4)...");
			System.out.println("Enter your value for X3.");
			String x3 = input.nextLine();
			while (x3.trim().length() == 0) {
				System.out.println("Please enter a value for \"x3\".");
				x3 = input.nextLine();
			}
			System.out.println("Enter your value for Y3.");
			String y3 = input.nextLine();
			while (y3.trim().length() == 0) {
				System.out.println("Please enter a value for \"y3\".");
				y3 = input.nextLine();
			}

			System.out.println("Enter your value for X4.");
			String x4 = input.nextLine();
			while (x4.trim().length() == 0) {
				System.out.println("Please enter a value for \"x4\".");
				x4 = input.nextLine();
			}
			System.out.println("Enter your value for Y4.");
			String y4 = input.nextLine();
			while (y4.trim().length() == 0) {
				System.out.println("Please enter a value for \"y4\".");
				y4 = input.nextLine();
			}

			try {
				/**
				 * (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
				 * (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
				 */
				double a = Double.parseDouble(y1) - Double.parseDouble(y2);
				double b = Double.parseDouble(x1) - Double.parseDouble(x2);
				double e = a * Double.parseDouble(x1) - b * Double.parseDouble(y1);
				double c = Double.parseDouble(y3) - Double.parseDouble(y4);
				double d = Double.parseDouble(x3) - Double.parseDouble(x4);
				double f = c * Double.parseDouble(x3) - d * Double.parseDouble(y3);
				LinearEquation linearEquation = new LinearEquation(String.valueOf(a), String.valueOf(-b), String.valueOf(c), String.valueOf(-d), String.valueOf(e), String.valueOf(f));
				if (linearEquation.isSolvable()) {
					System.out.println("X is " + linearEquation.getX());
					System.out.println("Y is " + linearEquation.getY());
				} else {
					System.out.println("The equation has no solution.");
				}
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

			System.out.println("Would you like to test for another number? Type 'no' to exit, or 'yes' to continue ");
			String toContinue = input.nextLine();
			if (toContinue.equals("yes")) {   //test for users input to continue the loop
					next = true;
			} else if(toContinue.equals("no")){
					next = false;
			} else {
					next = false;
			}
		}

		System.out.println("Program exit.");
	}
}