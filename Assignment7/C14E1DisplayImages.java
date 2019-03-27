/**
 *
 * @author Jonathan Fishkin, Bhavya Shah
 * I pledge that I have abided by the Stevens Honor System
 * Chapter 14 exercise 1
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class C14E1DisplayImages extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView image1 = new ImageView(new Image("UK.gif"));
        ImageView image2 = new ImageView(new Image("china.gif"));
        ImageView image3 = new ImageView(new Image("canada.gif"));
        ImageView image4 = new ImageView(new Image("UnitedStates.gif"));

        primaryStage.setTitle("C14E1 Display Images");

        GridPane root = new GridPane();
        root.add(image1, 0, 0);
        root.add(image2, 0, 1);
        root.add(image3, 1, 0);
        root.add(image4, 1, 1);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}