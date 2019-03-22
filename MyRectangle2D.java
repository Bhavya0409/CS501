/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 10 exercise 13
 */

 public class MyRectangle2D {
    private double x, y, width, height;
    private String errorMessage = "Error";
    public MyRectangle2D() { //empty constructor
        this(0,0,1,1);
    }

    public MyRectangle2D(double x, double y, double width, double height){ //if a point is entered
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public void setX(double x) throws Exception{
        if(!isValid(x)){
            throw new Exception(errorMessage);
        }
        this.x = x;
    }

	public void setY(double y) throws Exception{
        if(!isValid(y)){
            throw new Exception(errorMessage);
        }
		this.x = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
    }
    
	public void setWidth(double width) throws Exception{
        if(!isValid(width)){
            throw new Exception(errorMessage);
        }
		this.width = width;
	}

	public void setHeight(double height) throws Exception{
        if(!isValid(height)){
            throw new Exception(errorMessage);
        }
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
    }
    
    private boolean isValid(double value){
        if(value <= 0){
            errorMessage="Please enter a number thats greater than zero";
            return false;
        }
        return true;
    }

	public double getArea() {
		return width * height;
    }
    
	public double getPerimeter() {
		return 2 * (width + height);
	}

 }