/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 10 exercise 13
 */
 import java.util.*;
 public class TestMyRectangle2D {

    private static boolean next = true;
    private static boolean secondLoop = true;
    private static boolean thirdLoop = true;
     public static void main(String[] args) {
        System.out.println("This program asks for a base rectangle and then a reference rectangle to test against the base rectangle");
        Scanner input = new Scanner(System.in);
        while(next){
            while(secondLoop){
                System.out.println("Please enter x1 for the center of the base rectangle.");
                String x1 = input.nextLine();
                while (x1.trim().length() == 0) {
                    System.out.println("Please enter x1 for the center of the base rectangle.");
                    x1 = input.nextLine();
                }
                System.out.println("Please enter y1 for the center of the base rectangle.");
                String y1 = input.nextLine();
                while (y1.trim().length() == 0) {
                    System.out.println("Please enter y1 for the center of the base rectangle.");
                    y1 = input.nextLine();
                }
                System.out.println("Please enter width for the base rectangle.");
                String width1 = input.nextLine();
                while (width1.trim().length() == 0) {
                    System.out.println("Please enter width for the base rectangle.");
                    width1 = input.nextLine();
                }
                System.out.println("Please enter height for the base rectangle.");
                String height1 = input.nextLine();
                while (height1.trim().length() == 0) {
                    System.out.println("Please enter height for the base rectangle.");
                    height1 = input.nextLine();
                }

                try {
                    MyRectangle2D baseRectangle = new MyRectangle2D(Double.parseDouble(x1), Double.parseDouble(y1), Double.parseDouble(width1), Double.parseDouble(height1));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
        input.close();
        System.out.println("Program exit.");
     }
 }
