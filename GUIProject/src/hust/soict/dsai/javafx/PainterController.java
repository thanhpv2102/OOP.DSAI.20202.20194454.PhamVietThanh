package hust.soict.dsai.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController implements Initializable{
	
	@FXML
	private Pane drawingAreaPane;
		
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	
	ToggleGroup tools = new ToggleGroup();
	 
	@FXML
	RadioButton r_pen;
	
	@FXML
	RadioButton r_eraser;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		r_pen.setToggleGroup(tools);
		r_pen.setSelected(true);
		r_eraser.setToggleGroup(tools);
	}
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		RadioButton button = (RadioButton) tools.getSelectedToggle();
        if (button.getText().equals("Pen")) {
        	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    		drawingAreaPane.getChildren().add(newCircle);
        } else if (button.getText().equals("Eraser")) {
        	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
        }
	}
}
