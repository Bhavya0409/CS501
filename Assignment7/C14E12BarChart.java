/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 14 exercise 12
 */
import java.util.HashMap;

import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class C14E12BarChart extends Application {

    private static HashMap<String, Rectangle> allValues = new HashMap<String, Rectangle>();
    private static int total = 150;
    private static int width = 75;

    public void start(Stage primaryStage) throws Exception {
        Rectangle r1 = new Rectangle(0, 0, width, total * 0.20); //gets percentage out of 100 where total is 150 for better displaying purposes
        r1.setFill(Color.RED);
        Rectangle r2 = new Rectangle(0, 0, width, total * 0.26);
        r2.setFill(Color.BLUE);
        Rectangle r3 = new Rectangle(0, 0, width, total * 0.28);
        r3.setFill(Color.GREEN);
        Rectangle r4 = new Rectangle(0, 0, width, total * 0.26);
        r4.setFill(Color.ORANGE);

        allValues.put("Apple", r1);
        allValues.put("HTC", r2);
        allValues.put("Samsung", r3);
        allValues.put("Other", r4);

        HBox hbox = setHbox(allValues);
        primaryStage.setTitle("C14E12 Bar Chart");
        StackPane pane = new StackPane();
        pane.getChildren().add(hbox);

        Scene scene = new Scene(pane, 400, 75);
        primaryStage.setScene(scene);
        primaryStage.show();

    }     
    public static void main(String[] args) {
        launch(args);
    }

    public HBox setHbox(HashMap<String, Rectangle> values){
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_CENTER);

        for ( String key : values.keySet() ) {
            Text t1 = new Text();
            switch(key){   //switch statement based on key
                case "Apple":
                t1 = new Text(0, 0, key + " -- " + "20%");
                break;

                case "HTC":
                t1 = new Text(0, 0, key + " -- " + "26%");
                break;

                case "Samsung":
                t1 = new Text(0, 0, key + " -- " + "28%");
                break;

                case "Other":
                t1 = new Text(0, 0, key + " -- " + "26%");
                break;

            }
            VBox vBox = new VBox(5);  //sets the vertical gap between elements
            vBox.setAlignment(Pos.BOTTOM_CENTER); //sets the vertical alignment
            vBox.getChildren().addAll(t1, values.get(key));
            hbox.getChildren().add(vBox); //adds the vertical box to the horizontal box
        }


        return hbox;
    }
}