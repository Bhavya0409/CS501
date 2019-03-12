/**
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 9 exercise 11/12 Test class
 */
import java.util.*;

public class TestLinearEquation {

	private static boolean next = true;

	public static void main(String args[]) {
		System.out.println("This program solves a system of linear equations.");
		Scanner input = new Scanner(System.in);
		while(next) {
			System.out.println("The equations will be of the format \"ax + by = e\" and \"cx + dy = f\"");
			System.out.println("Enter your value for a.");
			String a = input.nextLine();
			while (a.trim().length() == 0) {
				System.out.println("Please enter a value for \"a\".");
				a = input.nextLine();
			}
			System.out.println("Enter your value for b.");
			String b = input.nextLine();
			while (b.trim().length() == 0) {
				System.out.println("Please enter a value for \"b\".");
				b = input.nextLine();
			}
			System.out.println("Enter your value for c.");
			String c = input.nextLine();
			while (c.trim().length() == 0) {
				System.out.println("Please enter a value for \"c\".");
				c = input.nextLine();
			}
			System.out.println("Enter your value for d.");
			String d = input.nextLine();
			while (d.trim().length() == 0) {
				System.out.println("Please enter a value for \"d\".");
				d = input.nextLine();
			}
			System.out.println("Enter your value for e.");
			String e = input.nextLine();
			while (e.trim().length() == 0) {
				System.out.println("Please enter a value for \"e\".");
				e = input.nextLine();
			}
			System.out.println("Enter your value for f.");
			String f = input.nextLine();
			while (f.trim().length() == 0) {
				System.out.println("Please enter a value for \"f\".");
				f = input.nextLine();
			}

			try {
				LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
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