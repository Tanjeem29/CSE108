package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label label;

    public void buttonPressed(ActionEvent actionEvent) {
        System.out.println("Button Clicked!!");
        label.setText("Button Clicked!!");
    }
}