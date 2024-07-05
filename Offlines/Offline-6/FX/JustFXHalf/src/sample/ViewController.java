package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ViewController {

    private Main main;

    @FXML
    public TextArea text;

    @FXML
    public Button backButton;



    public void backToHome(ActionEvent actionEvent) {
        try {
            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }
}
