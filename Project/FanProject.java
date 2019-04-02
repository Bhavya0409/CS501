import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import java.awt.BorderLayout;
import java.util.Random;
import javafx.scene.layout.Border;

public class FanProject extends StackPane {
	private double startAngle = 10; // Start angle of arcs for the fan
	private Timeline fan; // animation element
	private Color colorBlades = getRandomColor();
	private Pane blades;
	private ObservableList<Node> list;
	private double width = 0;
	private double height = 0;

	public FanProject(double width, double height) {  //constructs a fan pane
		this.width = width;
		this.height = height;

		blades = getFullPane(); // Create four arcs
		list = blades.getChildren(); // List of arcs

		getChildren().add(blades);
		fan = new Timeline(new KeyFrame(Duration.millis(50), e -> spinFan()));
	    fan.setCycleCount(Timeline.INDEFINITE);
		fan.play(); // Start animation
	}

	protected void spinFan() { //animate bladed spinning
		for (int i = 1; i < list.size(); i++) {
			Arc a = (Arc)list.get(i);
			a.setStartAngle(a.getStartAngle() + startAngle);
		}
	}

	public void pause() { //pause animation
		fan.pause();
	}

	public void play() { //play animation
		fan.play();
	}

	protected void reverse() { //reverse the direction
		startAngle *= -1;
	}

	protected void setRandomColor(){
		colorBlades = getRandomColor();
		for (int i = 1; i < list.size(); i++) {
			Arc a = (Arc)list.get(i);
			a.setFill(colorBlades);
		}
	}

	private Color getRandomColor(){
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r,g,b, 1);
		return randomColor;
	}

	private Pane getFullPane() { //Add 4 arcs to a pane and place them in a stack pane
		Pane pane = new Pane();
		Arc[] blades = new Arc[4];

		double radius = 100;
		double bladeRadius = radius * 0.9;

		Circle c = new Circle();
		c.setRadius(radius);
		c.setStroke(Color.BLACK);
		c.setFill(Color.TRANSPARENT);
		c.setLayoutX(this.width / 2);
		c.setLayoutY(this.width / 2);



		for (int i = 0; i < blades.length; i++) {
			blades[i] = new Arc(c.getCenterX(), c.getCenterY(), bladeRadius, bladeRadius, (i*90) + 30, 35);
			blades[i].setFill(colorBlades);
			blades[i].setType(ArcType.ROUND);
			blades[i].setLayoutX(this.width / 2);
			blades[i].setLayoutY(this.height / 2);
		}


		pane.getChildren().addAll(c);
		pane.getChildren().addAll(blades);

		return pane;
	}
}