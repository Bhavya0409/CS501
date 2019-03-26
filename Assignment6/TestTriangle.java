/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 10 exercise 13
 */
import java.util.*;

public class TestTriangle {

	private static boolean next = true;

	public static void main(String[] args) {
		System.out.println("This program will ask for 3 sides of a triangle, a color," +
		" and a filled attribute and will return a triangle and list some traits.");

		Scanner in = new Scanner(System.in);

		while(next){
			List<Double> sides = new ArrayList<>();
			while (sides.size() != 3) {
				System.out.println("Please enter a side of the rectangle.");
				String side = in.nextLine();
				while (side.trim().length() == 0) {
						System.out.println("Please enter a valid number.");
						side = in.nextLine();
				}
				try {
					double sideDouble = Double.parseDouble(side);
					sides.add(sideDouble);
				} catch (Exception e) {
					System.out.println("That is not a valid number.");
				}
			}

			try {
				Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
				System.out.println("Please enter a color.");
				String color = in.nextLine();
				while (color.trim().length() == 0) {
						System.out.println("Please enter something.");
						color = in.nextLine();
				}

				System.out.println("Is the triangle filled? Please enter yes or no");
				String filled = in.nextLine();
				while (filled.trim().length() == 0 || (!filled.trim().equals("yes") && !filled.trim().equals("no"))) {
						System.out.println("Please enter yes or no.");
						filled = in.nextLine();
				}

				boolean filledBoolean = false;
				if (filled.equals("yes")) {
					filledBoolean = true;
				}

				String filledText = filledBoolean ? "filled" : "not filled";
				System.out.println("Your triangle is " + color + " and it is " + filledText + ". The area is " + triangle.getArea() + " and its perimeter is " + triangle.getPerimeter());

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println("Would you like to restart the entire program? Type 'no' to exit, or 'yes' to continue ");
			String toContinue = in.nextLine();
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