package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class SearchRegController {

    @FXML
    public TextField regID;

    @FXML
    public Button searchButton;

    private Main main;

    @FXML
    public TextArea results;

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

    public void SearchReg(ActionEvent actionEvent) {
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
            if(s.equalsIgnoreCase("12345"))
                break;
            text.append(s+'\n');
        }
        results.setText(text.toString());
    }
}
