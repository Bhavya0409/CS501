import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
public class FanMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		FanProject fanPane = new FanProject();

		// Create three buttons
		Button Pause = new Button("Pause");
		Button Resume = new Button("Resume");
		Button Reverse = new Button("Reverse");
		Button setColor = new Button("Random Color");
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);

		// Place nodes in panes
		hBox.getChildren().addAll(Pause, Resume, Reverse, setColor);


		// Create a border pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(fanPane);
		borderPane.setBottom(hBox);

		Pause.setOnAction(e -> {
			fanPane.pause();
		});

		Resume.setOnAction(e -> {
			fanPane.play();
		});

		Reverse.setOnAction(e -> {
			fanPane.reverse();
		});

		setColor.setOnAction(e -> {
			fanPane.setRandomColor();
		});
		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 350, 350);
		primaryStage.setTitle("Exercise_15_28"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		fanPane.requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }
}