package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class ViewController {

    Socket s;
    PrintWriter out;
    BufferedReader in;
    private Main main;

    @FXML
    public TextArea text;

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
    void setSocket(Socket s){ this.s = s;}
    public void viewAll(ActionEvent actionEvent) throws IOException {
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out.println("viewAll");
        new ReadThread( in , text);
    }
}
