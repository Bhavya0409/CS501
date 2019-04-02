import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

public class CarProject extends Pane {
    private double x = 0;
	private double y = 100;
    private double radius = 5;
    private Circle circle1;
	private Circle circle2;
	private Timeline animation;
	private Rectangle rectangle;
    private Polygon polygon;
    private double rate;

    public CarProject(){
        drawCar(Color.RED);
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveTheCar()));
		animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    
	/** Create a car an place it in the pane */
	private void drawCar(Color carColor) {
		getChildren().clear();
        rectangle = new Rectangle(x, y - 20, 50, 10);
        rectangle.setFill(carColor);
        circle1 = new Circle(x + 15, y - 5, radius);
        circle1.setFill(carColor);
        circle2 = new Circle(x + 35, y - 5, radius);
        circle2.setFill(carColor);
        polygon = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
        polygon.setFill(carColor);
		getChildren().addAll(rectangle, circle1, circle2, polygon);
	}

	public void pause() {
        animation.pause(); //pause animation
        drawCar(Color.RED);
	}


    public boolean play() { //play animation
        boolean moving = true;
        animation.play();
        if(rate <= 0){
            moving = false;
        }
        return moving;

	}

    public void increasingSpeed() { //increase speed by 1
        rate = animation.getRate();
        animation.setRate(rate + 1);
	}

    public boolean decreasingSpeed() { // decrease rate by 1
        boolean stopped = false;
        if(rate > 0){
            rate = rate - 1;
            stopped = true;
        } else {
            rate = 0;
            drawCar(Color.RED);
        }
        animation.setRate(rate);
        return stopped;
	}

	protected void moveTheCar() { //Redraw car with specific new x value
		if (x <= getWidth() && rate > 0) {
            drawCar(Color.GREEN);	
            x = x + 1;
		} 
		else if(x >= getWidth()) {
            x = 0;   
        }
	}

}