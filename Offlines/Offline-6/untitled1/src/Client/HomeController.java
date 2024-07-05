package Client;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController {

    private Client client;

    @FXML
    private Label message;


    @FXML
    private Button button;

    public void init(String msg) {
        message.setText(msg);
    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            client.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Client c) {
        this.client = c;
    }

}

