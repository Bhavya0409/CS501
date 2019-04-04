import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.geometry.Point2D;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import java.util.Collections;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.text.Font;
public class ClockProject extends Pane {
    private int hour;
    private int minute;
    private int second;
    private String day;
    private Timeline animation;

    /** Construct a default clock with the current time*/
    public ClockProject() {
        setCurrentTime();
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> moveClock()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
    }

    /** Construct a clock with specified hour, minute, and second */
    public ClockProject(int hour,int minute,int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /** Return hour */
    public int getHour() {
        return hour;
    }

    /** Set a new hour */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /** Return minute */
    public int getMinute() {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /** Return second */
    public int getSecond() {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    public String getDay(){
        return this.day;
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        int i = calendar.get(Calendar.DAY_OF_WEEK); //Sets the day of the week based on the return from the calendar
        if(i == 2){
            this.day = "Monday";           
        } else if (i==3){
            this.day = "Tuesday";
        } else if (i==4){
            this.day = "Wednesday";
        } else if (i==5){
            this.day = "Thursday";
        } else if (i==6){
            this.day = "Friday";
        } else if (i==7){
            this.day = "Saturday";
        } else if (i==1){
            this.day = "Sunday";
        }

        paintClock(); // Repaint the clock
    }

    /** Paint the clock */
    private void paintClock() {
        // Initialize clock parameters
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double clockRadius2 = Math.min(getWidth(), getHeight()) * 0.4 * 0.25;
        double centerX = getWidth() /2;
        double centerY = getHeight() /2;
        double centerY2 = getHeight() / 2  + 50;
        Point2D center = new Point2D(centerX, centerY);
        Point2D center2 = new Point2D(centerX, centerY2);

        // Draw circles
        Circle circle = new Circle(centerX, centerY, clockRadius);
        Circle circle2 = new Circle(centerX, centerY2, clockRadius2);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
       
        // Draw time numbers
        Text[] textValues = new Text[12];
        for (int i = 0; i < 12; i++) {
            int time = (i + 3 > 12) ? i + 3 - 12 : i + 3;
            Point2D b = new Point2D(centerX + clockRadius * Math.cos(i * 2 * Math.PI / 12), centerY + clockRadius * Math.sin(i * 2 * Math.PI / 12));
            b = getPointBCloserToA(center, b, 0.82);
            textValues[i] = new Text(b.getX() - (clockRadius * 0.03125), b.getY() + (clockRadius * 0.025), "" + time);
        }

        // Draw dashes

        Line[] dashValuesBig = new Line[12];
        for (int i = 0; i < dashValuesBig.length; i++) {
            Point2D start = new Point2D(centerX + clockRadius * Math.cos(i * 2 * Math.PI / 12), centerY + clockRadius * Math.sin(i * 2 * Math.PI / 12));
            Point2D end = getPointBCloserToA(center,start, 0.91);
            dashValuesBig[i] = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        }

        Line[] dashValues = new Line[60];
        for (int i = 0; i < dashValues.length; i++) {
            Point2D start = new Point2D(centerX + clockRadius2 * Math.cos(i * 2 * Math.PI / 60), centerY2 + clockRadius2 * Math.sin(i * 2 * Math.PI / 60));
            double coefficient = (i % 5 == 0) ? 0.91 : 0.955;
            Point2D end = getPointBCloserToA(center2,start, coefficient);
            dashValues[i] = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        }


        // Draw second hand on smaller clock
        double sLength = clockRadius2 * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY2 - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY2, secondX, secondY);
        sLine.setStroke(Color.RED);

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
        Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
        Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);
        
        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
        Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
        Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        //Draw current time and day
        String time = "Current Time: " + getHour() + ":" + getMinute() + ":" + getSecond();
        String day = getDay();
        Text timeText = new Text(centerX - (centerX * 0.3), centerY - (centerY * 0.9), time);
        Text dateText = new Text(centerX - (centerX * 0.15), centerY - (centerY * 0.4), day);
        dateText.setFont(new Font("Arial", 14));
        dateText.setStroke(Color.DARKBLUE);
        dateText.setStrokeWidth(0.5);

        //Clear all nodes and then append them
        getChildren().clear();
        ObservableList<Node> list = getChildren();
        list.add(circle);
        list.add(circle2);
        list.add(dateText);
        Collections.addAll(list, dashValuesBig);
        Collections.addAll(list, dashValues);
        Collections.addAll(list, textValues);
        list.addAll(sLine, mLine, hLine, timeText);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }

    //Method to resolve how close points are to each other
    private Point2D getPointBCloserToA(Point2D a, Point2D b, double coefficient) {

        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();

        return new Point2D(a.getX() + coefficient * deltaX, a.getY() + coefficient * deltaY);
    }

    /* Animate the clock */
	protected void moveClock() {
		if (minute == 60) {
			hour += 1; 
		}	
		if (second == 60) {
			minute += 1;
		}
		second = (second < 60 ? second + 1 : 1);
		paintClock();	
	}

	public void play() {
		animation.play();
	}

	public void pause() {
		animation.pause();
	}

}