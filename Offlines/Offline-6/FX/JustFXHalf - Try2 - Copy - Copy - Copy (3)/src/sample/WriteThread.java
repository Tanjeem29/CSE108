package sample;

import java.io.PrintWriter;
import java.util.Scanner;

class WriteThread implements Runnable{
    PrintWriter out;
    String in;
    Thread t;
    public WriteThread(PrintWriter out, String s)
    {
        this.out = out;
        in = s;
        t= new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        //String in;
        //Scanner sc = new Scanner(System.in); //replace with fx features;
        try{
//            while(true){
//                in = sc.nextLine();
//                out.println(in);
//                if(in.equalsIgnoreCase("8")) // Implement fx
//                    break;
//            }

            out.println(in);
        }finally{
            out.close();
        }
    }
}
