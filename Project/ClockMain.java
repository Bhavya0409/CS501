import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
public class ClockMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Create a clock and a label
		ClockProject clock = new ClockProject();
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
	//	clock.setSecondHandVisible(false); // Make second hand invisible
		Label time = new Label(timeString);

		// Place clock and label in border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(time);
		BorderPane.setAlignment(time, Pos.TOP_CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 250); 
		primaryStage.setTitle("Exercise_14_28"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}