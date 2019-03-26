public class Triangle extends GeometricObject {
	double side1 = 1.0;
	double side2 = 1.0;
	double side3 = 1.0;

	public Triangle() {
		super();
	}

	public Triangle(double side1, double side2, double side3) throws Exception {
		if ((side1 + side2 < side3) || (side1 + side3 < side2) || (side3 + side2 < side1)) {
				throw new Exception("No side can have a length greater than the sum of the other sides.");
		}
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return this.side1;
	}

	public double getSide() {
		return this.side2;
	}

	public double getSide3() {
		return this.side3;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	public double getArea() {
		double s = (this.side1 + this.side2 + this.side3)/2;
		return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
	}

	public double getPerimeter() {
		return this.side1 + this.side2 + this.side3;
	}

	public String toString() {
		return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
	}
}