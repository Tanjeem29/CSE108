package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SearchMakeController {

    private Main main;
    Socket s;
    PrintWriter out;
    BufferedReader in;

    @FXML
    public TextField makeText;

    @FXML
    public TextField modelText;

    @FXML
    public Button searchButton;

    @FXML
    public TextArea results;

    @FXML
    public Button backButton;

    void setMain(Main main) {
        this.main = main;
    }
    void setSocket(Socket s){ this.s = s;}

    public void SearchMake(ActionEvent actionEvent) throws IOException {
        results.setText("");
        //searchButton.setDisable(true);
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String Make = makeText.getText();
        String Model = modelText.getText();
        String send = "makeSearch:" + Make + ":" + Model;
        out.println(send);
        new ReadThread(in, results);
//        int i = 1;
//        StringBuilder text = new StringBuilder();
//        //text.append(ID + '\n');
//        String s ="";
//        while(true){
//            s = s + i;
//            i++;
//            if(s.equalsIgnoreCase("1234567891011121314151617181920"))
//                break;
//            text.append(s+'\n');
//        }
        //results.setText(text.toString());
    }

    public void backToHome(ActionEvent actionEvent) {
        try {

            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
