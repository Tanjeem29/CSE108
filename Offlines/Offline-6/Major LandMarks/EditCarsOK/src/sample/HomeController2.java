package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeController2 {

    private Main main;

    @FXML
    private Label message;


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

    public void viewAction2(ActionEvent actionEvent) {
        try {
            main.showViewPage2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void addAction(ActionEvent actionEvent) {
        try {
            main.showAddPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editAction(ActionEvent actionEvent) {
        try {
            main.showEditPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAction(ActionEvent actionEvent) {
        try {
            main.showDeletePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
