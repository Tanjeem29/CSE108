package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController {

    private Main main;

    @FXML
    private Label message;

    @FXML
    private ImageView image;

    @FXML
    private Button button;

//    public void init(String msg) {
//        message.setText(msg);
//        Image img = new Image(Main.class.getResourceAsStream("1.png"));
//        image.setImage(img);
//    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void viewAction(ActionEvent actionEvent) {
        try {
            main.showViewPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchRegAction(ActionEvent actionEvent) {
        try {
            main.showSearchRegPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchMakeAction(ActionEvent actionEvent) {
        try {
            main.showSearchMakePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buyCarAction(ActionEvent actionEvent) {
        try {
            main.showBuyPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
