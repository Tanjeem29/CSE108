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
import java.util.Scanner;

public class SearchRegController {

    private Main main;
    Socket s;
    PrintWriter out;
    BufferedReader in;

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
    void setSocket(Socket s){ this.s = s;}

    public void backToHome(ActionEvent actionEvent) {
        try {
            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void SearchReg(ActionEvent actionEvent) throws IOException {
        results.setText("");
        searchButton.setDisable(true);
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String ID = regID.getText();
        String send = "regSearch:" + ID;
        String[] s2 = send.split(":");
        //results.setText(ID);

        //send regID to clienthandler
        //forloop, logic for regsearch
        //return strings through stream
//        try{
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }
//
//
//
//
//

//        results.setText(send);
//        try{
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }
//        results.setText(s2[0]);
//        try{
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }
          results.setText(s2[1]);
//        try{
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }

        out.println(send);
        new ReadThread(in, results);

//        Scanner in = new Scanner(System.in);
//        int i = 1;
//        StringBuilder text = new StringBuilder();
//        text.append(ID + '\n');
//        String s ="";
//        while(true){
//            s = s + i;
//            i++;
//            if(s.equalsIgnoreCase("1234567891011121314151617181920"))
//                break;
//            text.append(s+'\n');
//        }
//        results.setText(text.toString());
    }
}
