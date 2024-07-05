package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AddPageController {
    public TextField yrMade;
    public TextField c1;
    public TextArea confirmation;
    public TextField c2;
    public TextField c3;
    public TextField make;
    public TextField regID;
    public TextField price;
    public TextField model;

    private Main main;
    Socket s;
    PrintWriter out;
    BufferedReader in;

    void setMain(Main main) {
        this.main = main;
    }
    void setSocket(Socket s){ this.s = s;}

    public void addAction(ActionEvent actionEvent) throws IOException {
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String rID= regID.getText();
        String year=yrMade.getText();
        String co1=c1.getText();
        String co2=c2.getText();
        String co3=c3.getText();
        String ma=make.getText();
        String mo=model.getText();
        String p=price.getText();
        String send = "addcar:" + rID + ":" + year + ":"+ co1 + ":"+ co2 + ":"+ co3 + ":"+ ma + ":"+ mo + ":"+ p;

        out.println(send);
        new ReadThread(in, confirmation);

    }

    public void resetAction(ActionEvent actionEvent) {
        regID.setText("");
        yrMade.setText("");
        c1.setText("");
        c2.setText("");
        c3.setText("");
        make.setText("");
        model.setText("");
        price.setText("");
        confirmation.setText("");
    }

    public void backToHome2(ActionEvent actionEvent) {
        try {
            main.showHomePage2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
