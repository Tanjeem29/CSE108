package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;


public class LoginController {

    Socket s;
    PrintWriter out;
    BufferedReader in;
    private Main main;

    private static HashMap<String,String> IDs = new HashMap<String, String>();
    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    void loginAction(ActionEvent event) throws IOException {

//        IDs.put("a","1");
//        IDs.put("b","2");
//        IDs.put("c","3");
//        IDs.put("d","4");
//        IDs.put("e","5");
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //IDThread ID = new IDThread(IDs, s, in , out);
        //try{Thread.sleep(100);}catch(Exception e){}

        new IDThread(IDs, s, in , out);


        int user=0;
        String UID = userText.getText();
        String Pass = passwordText.getText();
        if(UID.equals("viewer") && Pass.equals(""))
        {
//                    out.println("Welcome Viewer! Please have a look around!!");
                user = 2;
        }
        for(String s :IDs.keySet())
        {
            if(s.equals(UID) && IDs.get(s).equals(Pass))
            {
//                        out.println("Welcome, "+ s);
                user = 1;
            }
        }
//                out.println("Incorrect User ID and Password, Please Try Again");



        String validUserName = "admin";
        String validPassword = "123";

        if (user == 2) {
            // successful login for Manufacturer
            try {
                main.showHomePage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(user == 1)
        {
            // successful login for Viewer/Buyer
            try {
                main.showHomePage2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // failed login
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }

    @FXML
    void resetAction(ActionEvent event) {
        new IDThread(IDs, s, in , out);
        userText.setText("");
        passwordText.setText("");
    }

    void setMain(Main main) {
        this.main = main;
    }
    void setSocket(Socket s){ this.s = s;}
    void setIDs() throws IOException {
        out = new PrintWriter(s.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        IDThread ID = new IDThread(IDs, s, in , out);
    }
//    @FXML
//    void initialize(){
//
//    }

}
