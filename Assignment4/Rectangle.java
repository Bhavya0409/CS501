/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 9 exercise 1
 */
public class Rectangle {

	private double width = 1.0;
	private double height = 1.0;

	private String errorMessage = "Error";

	public Rectangle() {
		// Default Constructor
	}

	public Rectangle(String width, String height) throws Exception {
		setHeight(height);
		setWidth(width);
	}

	public void setWidth(String width) throws Exception {
		if (!isValid(width)) {
			throw new Exception(errorMessage);
		}
		this.width = Double.parseDouble(width);
	}

	public void setHeight(String height) throws Exception {
		if (!isValid(height)) {
			throw new Exception(errorMessage);
		}
		this.height = Double.parseDouble(height);
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	private boolean isValid(String number) {
		try {
			double parsed = Double.parseDouble(number);
			if (parsed <= 0) {
				errorMessage = "Please enter a number greater than 0.";
				return false;
			}
		} catch (Exception e) {
			errorMessage = "Please make sure both width and height values are valid numbers.";
			return false;
		}
		return true;
	}

	public double getArea() {
		return this.height * this.width;
	}

	public double getPerimeter() {
		return 2*(this.height + this.width);
	}

	public void print() {
		System.out.println("Width: " + this.getWidth());
		System.out.println("Height: " + this.getHeight());
		System.out.println("Area: " + this.getArea());
		System.out.println("Perimeter: " + this.getPerimeter());
	}
}
