package Server;

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
        String str = new String();
//        String Long[] = str.split(";");
//        int c=0;
        for(String s :IDs.keySet())
        {
            out.println(s+";"+ IDs.get(s));
        }
        out.println("$$DONE");

    }
}

