package sample;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

class ReadThread implements Runnable{
    BufferedReader in;
    Thread t;
    TextArea txt;
    public ReadThread(BufferedReader in, TextArea txt)
    {
        this.in = in;
        this.txt = txt;
        this.t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        String out = new String();
        try{
            while(true)
            {
                try {
                    out = in.readLine();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if(out.equalsIgnoreCase("$$viewAll")) {
                    StringBuilder results = new StringBuilder();
                    while (true) {
                        try {
                            out = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(results.toString());
                        }
                    });

                    break;
                }

                if(out.equalsIgnoreCase("$$regSearch")) {
                    StringBuilder results = new StringBuilder();
                    while (true) {
                        try {
                            out = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(results.toString());
                        }
                    });

                    break;
                }
                if(out.equalsIgnoreCase("$$makeSearch")) {
                    StringBuilder results = new StringBuilder();
                    while (true) {
                        try {
                            out = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(results.toString());
                        }
                    });
                    break;
                }
                if(out.equalsIgnoreCase("$$buyCar")) {
                    StringBuilder results = new StringBuilder();
                    while (true) {
                        try {
                            out = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(results.toString());
                        }
                    });
                    break;
                }
                if(out.equalsIgnoreCase("$$deleteCar")) {
                    StringBuilder results = new StringBuilder();
                    while (true) {
                        try {
                            out = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(results.toString());
                        }
                    });
                    break;
                }
                if(out.equalsIgnoreCase("$$editCar")) {
                    StringBuilder results = new StringBuilder();
                    while (true) {
                        try {
                            out = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(results.toString());
                        }
                    });
                    break;
                }
                if(out.equalsIgnoreCase("$$addCar")) {
                    StringBuilder results = new StringBuilder();
                    while (true) {
                        try {
                            out = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (out.equalsIgnoreCase("$$End"))
                            break;
                        results.append(out + '\n');
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            txt.setText(results.toString());
                        }
                    });
                    break;
                }
            }
        }
        finally{

        }
    }
}
