package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class BuyController {

    public Button searchButton;
    private Main main;

    @FXML
    public TextArea results;

    @FXML
    public TextField makeText;

    @FXML
    public TextField modelText;

    @FXML
    public TextField regID;

    void setMain(Main main) {
        this.main = main;
    }

    public void SearchMake(ActionEvent actionEvent) {
        results.setText("");
        searchButton.setDisable(true);
        int i = 1;
        StringBuilder text = new StringBuilder();
        //text.append(ID + '\n');
        String s ="";
        while(true){
            s = s + i;
            i++;
            if(s.equalsIgnoreCase("1234567891011121314151617181920"))
                break;
            text.append(s+'\n');
        }
        results.setText(text.toString());
    }

    public void BuyCar(ActionEvent actionEvent) {
        //add code here
    }

    public void backToHome(ActionEvent actionEvent) {
        try {
            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
