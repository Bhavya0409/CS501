/**
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 9 exercise 11/12
 */
public class LinearEquation {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;

	private String errorMessage = "Error";

	public LinearEquation(String a, String b, String c, String d, String e, String f) throws Exception {
		setA(a);
		setB(b);
		setC(c);
		setD(d);
		setE(e);
		setF(f);
	}

	public double getX() {
		double numerator = this.e * this.d - this.b * this.f;
		double denominator = this.a * this.d - this.b * this.c;
		return numerator/denominator;
	}

	public double getY() {
		double numerator = this.a * this.f - this.e * this.c;
		double denominator = this.a * this.d - this.b * this.c;
		return numerator/denominator;
	}

	public boolean isSolvable() {
		double result = a * d - b * c;
		if (result == 0) {
			return false;
		}
		return true;
	}

	private double getA() {
		return this.a;
	}

	private double getB() {
		return this.b;
	}

	private double getC() {
		return this.c;
	}

	private double getD() {
		return this.d;
	}

	private double getE() {
		return this.e;
	}

	private double getF() {
		return this.f;
	}

	private void setA(String value) throws Exception {
		if (!isValid(value)) {
			throw new Exception(errorMessage);
		}
		this.a = Double.parseDouble(value);
	}

	private void setB(String value) throws Exception {
		if (!isValid(value)) {
			throw new Exception(errorMessage);
		}
		this.b = Double.parseDouble(value);
	}

	private void setC(String value) throws Exception {
		if (!isValid(value)) {
			throw new Exception(errorMessage);
		}
		this.c = Double.parseDouble(value);
	}

	private void setD(String value) throws Exception {
		if (!isValid(value)) {
			throw new Exception(errorMessage);
		}
		this.d = Double.parseDouble(value);
	}

	private void setE(String value) throws Exception {
		if (!isValid(value)) {
			throw new Exception(errorMessage);
		}
		this.e = Double.parseDouble(value);
	}

	private void setF(String value) throws Exception {
		if (!isValid(value)) {
			throw new Exception(errorMessage);
		}
		this.f = Double.parseDouble(value);
	}

	private boolean isValid(String value) {
		try {
			double parsed = Double.parseDouble(value);
		} catch (Exception e) {
			errorMessage = "Please enter valid numbers.";
			return false;
		}
		return true;
	}
};