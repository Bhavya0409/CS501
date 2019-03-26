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
                System.out.println("Please enter x1 for the center of the BASE rectangle.");
                String x1 = input.nextLine();
                while (x1.trim().length() == 0) {
                    System.out.println("Please enter x1 for the center of the BASE rectangle.");
                    x1 = input.nextLine();
                }
                System.out.println("Please enter y1 for the center of the BASE rectangle.");
                String y1 = input.nextLine();
                while (y1.trim().length() == 0) {
                    System.out.println("Please enter y1 for the center of the BASE rectangle.");
                    y1 = input.nextLine();
                }
                System.out.println("Please enter width for the BASE rectangle.");
                String width1 = input.nextLine();
                while (width1.trim().length() == 0) {
                    System.out.println("Please enter width for the BASE rectangle.");
                    width1 = input.nextLine();
                }
                System.out.println("Please enter height for the BASE rectangle.");
                String height1 = input.nextLine();
                while (height1.trim().length() == 0) {
                    System.out.println("Please enter height for the BASE rectangle.");
                    height1 = input.nextLine();
                }

                try {
                    MyRectangle2D baseRectangle = new MyRectangle2D(Double.parseDouble(x1), Double.parseDouble(y1), Double.parseDouble(width1), Double.parseDouble(height1));
                    System.out.println("BASE rectangle area: " + baseRectangle.getArea()); 
                    System.out.println("BASE rectangle perimeter: " + baseRectangle.getPerimeter());
                    while(thirdLoop){
                        System.out.println("Please enter x2 for the center of the TEST rectangle.");
                        String x2 = input.nextLine();
                        while (x2.trim().length() == 0) {
                            System.out.println("Please enter x2 for the center of the TEST rectangle.");
                            x2 = input.nextLine();
                        }
                        System.out.println("Please enter y2 for the center of the TEST rectangle.");
                        String y2 = input.nextLine();
                        while (y2.trim().length() == 0) {
                            System.out.println("Please enter y2 for the center of the TEST rectangle.");
                            y2 = input.nextLine();
                        }
                        System.out.println("Please enter width for the TEST rectangle.");
                        String width2 = input.nextLine();
                        while (width2.trim().length() == 0) {
                            System.out.println("Please enter width for the TEST rectangle.");
                            width2 = input.nextLine();
                        }
                        System.out.println("Please enter height for the TEST rectangle.");
                        String height2 = input.nextLine();
                        while (height2.trim().length() == 0) {
                            System.out.println("Please enter height for the TEST rectangle.");
                            height2 = input.nextLine();
                        }
                        try {
                            MyRectangle2D testRectangle = new MyRectangle2D(Double.parseDouble(x2), Double.parseDouble(y2), Double.parseDouble(width2), Double.parseDouble(height2));
                            System.out.println("TEST rectangle area: " + testRectangle.getArea());
                            System.out.println("TEST rectangle perimeter: " + testRectangle.getPerimeter());         
                            System.out.println("Points (" + x2 + "," + y2 + ") from TEST rectangle " + (baseRectangle.contains(Double.parseDouble(x2), Double.parseDouble(y2)) ? "ARE": "ARE NOT")  + " contained in BASE rectangle" );
                            System.out.println("BASE rectangle " + (baseRectangle.contains(testRectangle)? "DOES" : "DOES NOT") + " contain TEST rectangle with points ("  + x2 + "," + y2 + "," + width2 + "," + height2 + ")");
                            System.out.println("TEST rectangle with points (" +  x2 + "," + y2 + "," + width2 + "," + height2 + ") " + (baseRectangle.overlaps(testRectangle) ? "OVERLAPS" : "DOES NOT OVERLAP") + " with BASE rectangle");
                            System.out.println("TEST rectangle with points (" +  x2 + "," + y2 + "," + width2 + "," + height2 + ") " + (baseRectangle.abutment(testRectangle) ? "HAS ABUTMENT" : "DOES NOT HAVE ABUTMENT") + " with BASE rectangle");
                            System.out.println("TEST rectangle with points (" +  x2 + "," + y2 + "," + width2 + "," + height2 + ") " + (baseRectangle.distinction(testRectangle) ? "IS DISTINCT" : "IS NOT DISTINCT") + " from BASE rectangle");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                        System.out.println("Would you like to enter a new TEST rectangle? Type 'no' to exit, or 'yes' to continue ");
                        String toTest = input.nextLine();
                        if (toTest.equals("yes")) {   //test for users input to continue the loop
                                thirdLoop = true;
                        } else if(toTest.equals("no")){
                                thirdLoop = false;
                        } else {
                                thirdLoop = false;
                        }
    
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Would you like to enter a new BASE rectangle? Type 'no' to exit, or 'yes' to continue ");
				String toContinue = input.nextLine();
				if (toContinue.equals("yes")) {   //test for users input to continue the loop
                        secondLoop = true;
                        thirdLoop = true;
				} else if(toContinue.equals("no")){
                        secondLoop = false;
				} else {
                        secondLoop = false;
				}

            }

            System.out.println("Would you like to restart the entire program? Type 'no' to exit, or 'yes' to continue ");
            String toContinue = input.nextLine();
            if (toContinue.equals("yes")) {   //test for users input to continue the loop
                    next = true;
                    secondLoop = true;
                    thirdLoop = true;
            } else if(toContinue.equals("no")){
                    next = false;
            } else {
                    next = false;
            }
        }
        input.close();
        System.out.println("Program exit.");
     }
 }
