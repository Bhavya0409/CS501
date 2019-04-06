import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Insets;

public class ProjectMain extends Application {

    private double width = 700;
	private double height = 350;

    @Override
    public void start(Stage primaryStage) throws Exception {

		RadioButton Fanbtn = new RadioButton("Fan Application");
		Fanbtn.setFocusTraversable(false);
		RadioButton Carbtn = new RadioButton("Car Application");
		Carbtn.setFocusTraversable(false);
		RadioButton Clockbtn = new RadioButton("Clock Application");
		Clockbtn.setFocusTraversable(false);
		
        VBox vBox = new VBox(50);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.getChildren().addAll(Fanbtn, Carbtn, Clockbtn);

		//Create the fan application
		FanProject fanPane = new FanProject();
		fanPane.setVisible(false);


		// Create a car application and create new borderpane
        BorderPane carPane = new BorderPane();
        Text helpText = new Text("Car Is Stopped");
        helpText.setFont(new Font("Time New Roman", 25));
		CarProject pane = new CarProject();

        carPane.setCenter(helpText);
        carPane.setBottom(pane);
        carPane.setMargin(helpText, new Insets(0, 0, -35, 0));

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
		
		carPane.setVisible(false);


		//Create Clock Application and new Border Pane
		ClockProject clock = new ClockProject();
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();

		// Create a hBox and set it properties
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);

		// Create two buttons
		Button btStop = new Button("Stop");
		Button btStart = new Button("Start");

		// Create and register handler
		btStop.setOnAction(e -> clock.pause());
		btStart.setOnAction(e -> clock.play());

		// Place buttons in hBox
		hBox.getChildren().addAll(btStart, btStop);

		// Create a border pane and place the nodes in to it
		BorderPane clockPane = new BorderPane();
		clockPane.setCenter(clock);
		clockPane.setBottom(hBox);
		clockPane.setVisible(false);


		// Create a border pane and place the nodes in to it
		BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBox);

		//If fan button is selected open fan application and disable other buttons
		Fanbtn.setOnAction(e -> {
			if(Fanbtn.isSelected()) {
				fanPane.setVisible(true);
				Carbtn.setDisable(true);
				Clockbtn.setDisable(true);
				borderPane.setCenter(fanPane);
			} else {
				fanPane.setVisible(false);
				Carbtn.setDisable(false);
				Clockbtn.setDisable(false);
				borderPane.setCenter(new BorderPane());
			}
		});

		//If car button is selected open car application and disable other buttons
		Carbtn.setOnAction(e -> {
			if(Carbtn.isSelected()) {
				carPane.setVisible(true);
				Fanbtn.setDisable(true);
				Clockbtn.setDisable(true);
				borderPane.setCenter(carPane);
				pane.requestFocus();
			} else {
				carPane.setVisible(false);
				Fanbtn.setDisable(false);
				Clockbtn.setDisable(false);
				borderPane.setCenter(new BorderPane());
			}
		});

		//If clock button is selected open fan application and disable other buttons
		Clockbtn.setOnAction(e -> {
			if(Clockbtn.isSelected()) {
				clockPane.setVisible(true);
				Fanbtn.setDisable(true);
				Carbtn.setDisable(true);
				borderPane.setCenter(clockPane);
			} else {
				carPane.setVisible(false);
				Fanbtn.setDisable(false);
				Carbtn.setDisable(false);
				borderPane.setCenter(new BorderPane());
			}
		});


		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, width, height);
		primaryStage.setTitle("Java Project"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setResizable(false);
		primaryStage.show(); // Display the stage
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}