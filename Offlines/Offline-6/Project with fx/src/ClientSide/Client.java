package ClientSide;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

class ReadThread implements Runnable{
    //Socket s;
    BufferedReader in;
    Thread t;
    public ReadThread(BufferedReader in)
    {
        //this.s = s;
        this.in = in;
        this.t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        String out;
        try{
            while(true)
            {
                out = in.readLine();
                System.out.println(out); //Include fx Stuff Here
                if(out.equalsIgnoreCase("Close"))
                    break;
            }


        }catch(IOException e){
            System.out.println(e);
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


class WriteThread implements Runnable{
    PrintWriter out;
    //String in;
    Thread t;
    public WriteThread(PrintWriter out)
    {
        this.out = out;
        //in = new String();
        t= new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        String in;
        Scanner sc = new Scanner(System.in); //replace with fx features;
        try{
            while(true){
                in = sc.nextLine();
                out.println(in);
                if(in.equalsIgnoreCase("6")) // Implement fx
                    break;
            }
        }finally{
            out.close();
        }
    }
}


public class Client {
    public static final String IP = "127.0.0.1";
    public static final int PORT = 44444;
    Socket s;
    BufferedReader in;
    PrintWriter out;

    public Client( String ip, int port) {
        try {
            s = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
            new ReadThread(in);
            new WriteThread(out);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client(IP,PORT);
    }
}
