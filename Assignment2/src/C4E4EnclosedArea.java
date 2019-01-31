/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 */

public class C4E4EnclosedArea {
    public static void main(String[] args){
        System.out.println("This program determines area enclosed by the quadrilateral formed by Atlanta, Georgia; Orlando,Florida; Savannah, Georgia; and Charlotte, North Carolina");
				double x1 = 35.2270869;
				double y1 = -80.8431267;
				double x2 = 33.7489954;
				double y2 = -84.3879824;
				double x3 = 28.5383355;
				double y3 = -81.3792365;
				double x4 = 32.0835407;
				double y4 = -81.0998342;

				System.out.println("The coordinates for Charlotte are (" + x1 + ", " + y1 + ")");
				System.out.println("The coordinates for Atlanta are (" + x2 + ", " + y2 + ")");
				System.out.println("The coordinates for Orlando are (" + x3 + ", " + y3 + ")");
				System.out.println("The coordinates for Savannah are (" + x4 + ", " + y4 + ")");
				System.out.println("");

				double side1 = getDistance(x1, y1, x2, y2);
				double side2 = getDistance(x2, y2, x3, y3);
				double side3 = getDistance(x3, y3, x4, y4);
				double side4 = getDistance(x4, y4, x1, y1);
				double middle = getDistance(x2, y2, x4, y4);

				System.out.println("The distance between Charlotte and Atlanta is " + side1);
				System.out.println("The distance between Atlanta and Orlando is " + side2);
				System.out.println("The distance between Orlando and Savannah is " + side3);
				System.out.println("The distance between Savannah and Charlotte is " + side4);
				System.out.println("");

				double s1 = (side1 + side4 + middle)/2;
				double s2 = (side2 + side3 + middle)/2;

				System.out.println("The middle line will connect Atlanta and Savannah.");

				System.out.println("The s value of the Charlotte, Atlanta and Savannah is " + s1);
				System.out.println("The s value of the Orlando, Atlanta and Savannah is " + s2);
				System.out.println("");

				double area1 = Math.sqrt(s1 * (s1 - side1) * (s1 - side4) * (s1 - middle));
				double area2 = Math.sqrt(s2 * (s2 - side2) * (s2 - side3) * (s2 - middle));

				System.out.println("The area of the triangle formed by Charlotte, Atlanta and Savannah is " + area1);
				System.out.println("The area of the triangle formed by Orlando, Atlanta and Savannah is " + area2);
				System.out.println("");

				double sum = area1 + area2;
				System.out.println("The area of the space enclosed is " + sum);
    }

		public static double getDistance(double x1, double y1, double x2, double y2) {
			return 6371.01 * Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) +
							Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1) - Math.toRadians(y2)));
		}
}