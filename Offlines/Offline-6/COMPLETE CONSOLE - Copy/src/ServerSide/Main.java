package ServerSide;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Main {
    public static final int PORT = 44444;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    public static final String FILE_NAME = "in.txt";
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    private static HashMap<String,String>IDs = new HashMap<String, String>();


    public static void main(String[] args) throws IOException {
        //change to cars.txt as per question
        IDs.put("a","1");
        IDs.put("b","2");
        IDs.put("c","3");
        IDs.put("d","4");
        IDs.put("e","5");
        CarDatabase cd = new CarDatabase();
        cd.readFile(FILE_NAME);
        ServerSocket ss;
        ss = new ServerSocket(PORT);
        int count=0;
        while(true){
            System.out.println("Server Waiting for Client Connection....");
            Socket s = ss.accept();
            count++;
            System.out.println("Connected to Client: " + count);
            ClientHandler cThread= new ClientHandler( s, cd, IDs);
            clients.add(cThread);
            threadPool.execute(cThread);

        }



    }

}
