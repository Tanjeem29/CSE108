package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class IDThread implements Runnable {
    Socket s;
    BufferedReader in;
    PrintWriter out;
    Thread t;
    HashMap<String,String > IDs;
    public IDThread(HashMap<String,String > IDs, Socket s, BufferedReader in, PrintWriter w){
        this.in = in;
        this.s = s;
        this.out = w;
        this.IDs=IDs;
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        out.println("IDsReq");
        String str= "";
        while(true){
            try {
                str = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(str.equalsIgnoreCase("$$Done"))
                break;
            String UIDPass[]= str.split(";");
            IDs.put(UIDPass[0],UIDPass[1]);
        }

    }
}
