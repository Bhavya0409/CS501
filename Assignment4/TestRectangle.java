/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */
import java.util.*;

public class TestRectangle {

	private static boolean next = true;

    public static void main(String[] args){
			System.out.println("This program asks for rectangle dimensions and returns the area and perimeter.");
			Scanner input = new Scanner(System.in);
			while(next) {
				System.out.println("Please enter the width of the rectangle.");
				String width = input.nextLine();
				System.out.println("Please enter the height of the rectangle.");
				String height = input.nextLine();
				try {
					Rectangle rectangle = new Rectangle(width, height);
					rectangle.print();
				} catch (Exception e) {
					System.out.println(e.getMessage());
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
