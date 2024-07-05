package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EditPageController {
    public TextField regID;
    public TextArea results;
    public TextArea confirmation;
    public TextField price;

    private Main main;
    Socket s;
    PrintWriter out;
    BufferedReader in;

    void setMain(Main main) {
        this.main = main;
    }
    void setSocket(Socket s){ this.s = s;}



    public void SearchReg(ActionEvent actionEvent) throws IOException {
        results.setText("");
        //searchButton.setDisable(true);
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String ID = regID.getText();
        String send = "regSearch:" + ID;
        String[] s2 = send.split(":");



        results.setText(s2[1]);


        out.println(send);
        new ReadThread(in, results);


    }

    public void backToHome2(ActionEvent actionEvent) {
        try {
            main.showHomePage2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EditCar(ActionEvent actionEvent) throws IOException {
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String ID = regID.getText();
        String p = price.getText();
        String send = "editCar:" + ID + ":" + p ;
        confirmation.setText(send);
        out.println(send);
        new ReadThread(in, confirmation);
    }
}
