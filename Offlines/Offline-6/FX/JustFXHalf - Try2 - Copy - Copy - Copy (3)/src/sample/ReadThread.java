package sample;
import javafx.scene.control.TextArea;

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
    TextArea txt;
    public ReadThread(BufferedReader in, TextArea txt)
    {
        //this.s = s;
        this.in = in;
        this.txt = txt;
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
                if(out.equalsIgnoreCase("$$Viewall:"))
                {
                    StringBuilder results= new StringBuilder();
                    while(true)
                    {
                        out = in.readLine();
                        if(out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    txt.setText(results.toString());
                    break;
                }
                //System.out.println(out); //Include fx Stuff Here
//                if(out.equalsIgnoreCase("Close"))
//                    break;

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
