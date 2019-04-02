import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CarMain extends Application {
    @Override // Override the start method on the Application class
    public void start(Stage primaryStage) {
        // Create a car
        BorderPane test = new BorderPane();
        Text helpText = new Text("Car Is Stopped");
        helpText.setFont(new Font("Time New Roman", 25));
        CarProject pane = new CarProject();

        test.setCenter(helpText);
        test.setBottom(pane);
        test.setMargin(helpText, new Insets(0, 0, -35, 0));

        // Create and register handles
        pane.setOnMousePressed(e ->{ 
            pane.pause();
            helpText.setText("Car Is Stopped");
        });
        pane.setOnMouseReleased(e -> {
            boolean moving = pane.play();
            if (moving){
                helpText.setText("Car Is Now Moving");
            } else {
                helpText.setText("Car Is Stopped");  
            }
        });
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) { //Happens when user clicks right arrow key
                pane.increasingSpeed();                 //increases speed and sets the text to moving
                helpText.setText("Car Is Now Moving");
            }
            else if (e.getCode() == KeyCode.LEFT) {
                boolean moving = pane.decreasingSpeed();
                if(moving){                                    //if the speed is decreasing but not at 0 the car will print is slowing down
                    helpText.setText("Car Is Slowing Down");
                } else {
                    helpText.setText("Car Is Stopped");         //either wise the car is completely stopped
                }
            }
        });

        Scene scene = new Scene(test, 600, 100);
        primaryStage.setTitle("Car Project"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        pane.requestFocus(); // Request focus
	}
}