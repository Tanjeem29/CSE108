package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class SearchRegController {

    private Main main;

    @FXML
    public TextField regID;

    @FXML
    public Button searchButton;

    @FXML
    public TextArea results;

    @FXML
    public Button backButton;

    void setMain(Main main) {
        this.main = main;
    }


    public void backToHome(ActionEvent actionEvent) {
        try {
            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void SearchReg(ActionEvent actionEvent) {
        results.setText("");
        searchButton.setDisable(true);
        String ID = regID.getText();
        //send regID to clienthandler
        //forloop, logic for regsearch
        //return strings through stream




//        Scanner in = new Scanner(System.in);
        int i = 1;
        StringBuilder text = new StringBuilder();
        text.append(ID + '\n');
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
}
