package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Main extends Application{

    Stage stage;
    BufferedReader in;
    PrintWriter out;

    public static final String IP = "127.0.0.1";
    public static final int PORT = 44444;
    Socket s;


    public void ConnectToServer(String ip, int port) {
        try {
            s = new Socket(ip, port);
//            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            out = new PrintWriter(s.getOutputStream(), true);
//            new ReadThread(in);
//            new WriteThread(out);

        }catch(Exception e){
            System.out.println(e);
        }
    }




    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        ConnectToServer(IP,PORT);
        showLoginPage();
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void showHomePage() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }

    public void showViewPage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ViewController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("View");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void showSearchRegPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchReg.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchRegController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By Registration Number");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void showSearchMakePage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchMake.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchMakeController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Search By Make and Model");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void showBuyPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("buy.fxml"));
        Parent root = loader.load();

        // Loading the controller
        BuyController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Buy Window");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }


}
