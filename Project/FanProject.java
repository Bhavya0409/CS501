import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import java.util.Random;

public class FanProject extends StackPane {
	private double startAngle = 10; // Start angle of arcs for the fan
	private Timeline fan; // animation element
	private Color colorBlades = getRandomColor();
	private Pane blades = getBlades(); // Create four arcs
	private ObservableList<Node> list = blades.getChildren(); // List of arcs

    public FanProject() {  //constructs a fan pane
        Circle c = new Circle();
		c.setRadius(100);
		c.setStroke(Color.BLACK);
		c.setFill(Color.WHITE);
		getChildren().addAll(c, blades);
		fan = new Timeline(new KeyFrame(Duration.millis(50), e -> spinFan()));
	    fan.setCycleCount(Timeline.INDEFINITE);
		fan.play(); // Start animation
	}

	protected void spinFan() { //animate bladed spinning
		for (int i = 0; i < list.size(); i++) {
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
		System.out.println(colorBlades.toString());
		blades = getBlades();
	}

	private Color getRandomColor(){
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r,g,b, 1);
		return randomColor;
	}

	private Pane getBlades() { //Add 4 arcs to a pane and place them in a stack pane
		Pane pane = new Pane();
		double angle = 0;
		for (int i = 0; i < 4; i++) {
			Arc arc = new Arc(125, 115, 90, 90, angle + 90, 50);
			arc.setFill(colorBlades);
			arc.setType(ArcType.ROUND);
			pane.getChildren().add(arc);
			angle += 90;
		}
		return pane;
	}
}