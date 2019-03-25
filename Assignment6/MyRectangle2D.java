/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 10 exercise 13
 */

 public class MyRectangle2D {
    private double x, y, width, height;
    private String errorMessage = "Error";
    public MyRectangle2D() throws Exception { //empty constructor
        this(0,0,1,1);
    }

    public MyRectangle2D(double x, double y, double width, double height) throws Exception{ //if a point is entered
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
		this.y = y;
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
            errorMessage="Error please provide numbers greater than 0";
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

    private double getDistance(double p1, double p2) { //gets the distance
		return Math.sqrt(Math.pow(p2 - p1, 2));
	}
    
	public boolean contains(double x, double y) {      //if specified points are inside rectangle
		return getDistance(this.y, y) <= height / 2 && getDistance(this.x, x) <= width / 2; 
	}

	public boolean contains(MyRectangle2D r) {  //test whether provided rectangle is inside this rectangle
		return getDistance(y, r.getY()) + r.getHeight() / 2 <= height / 2 &&  getDistance(x, r.getX()) + r.getWidth() / 2 <= width / 2 &&
			height / 2 + r.getHeight() / 2 <= height &&
		 	width / 2 + r.getWidth() / 2 <= width;
	}

	public boolean overlaps(MyRectangle2D r) {  //test if rectangles overlap
		return !contains(r) && ((x + width / 2 > r.getX() - r.getWidth()) || (y + height / 2 > r.getY() - r.getHeight()))  &&
		  		 (getDistance(y, r.getY()) < height / 2 + r.getHeight() / 2) && 
				 (getDistance(x, r.getX()) < width / 2 + r.getWidth() / 2);
    }
    
    public boolean abutment(MyRectangle2D r) {
        boolean rightSide = (x + width/2) == (r.getX() - r.getWidth() / 2);
        boolean leftSide = (r.getX() + r.getWidth() /2) == (x - width / 2);
        boolean upTop = (y + height / 2) == (r.getY() - r.getHeight() / 2);
        boolean downBottom = (r.getY() + r.getHeight() / 2) == (y - height / 2);

        return rightSide || leftSide || upTop || downBottom;
    }

    public boolean distinction(MyRectangle2D r){
        return !contains(r) && !overlaps(r) && !abutment(r);
    }

 }