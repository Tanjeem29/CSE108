package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private CarDatabase cd;
    private HashMap<String, String> IDs;

    public ClientHandler(Socket s, CarDatabase cd, HashMap hm) {
        IDs = hm;
        this.client = s;
        this.cd = cd;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try {

            while (true) {
                String cmd = in.readLine();
                String[] s = cmd.split(":");


                if (s[0].equalsIgnoreCase("IDsReq")) {
                    new IDThread(IDs, client, in, out);
                }

                if (s[0].equalsIgnoreCase("viewAll")) {
                    out.println("$$viewAll");
                    cd.viewCars(out);
                    out.println("$$End");
                }

                if (s[0].equalsIgnoreCase("regSearch")){

                    out.println("$$regSearch");
                    int searchIdx= 0;
                    try{searchIdx= cd.runRegSearch(s[1]);} catch (ArrayIndexOutOfBoundsException e){
                        out.println("ERROR! No Reg Number Entered");
                        out.println("$$End");
                    }
                    if(searchIdx == -1) {
                        out.println( "Not Found! No such car with this Registration Number");

                    }
                    else {
                        Car temp = cd.carList.get(searchIdx);
                        temp.display(out);
                    }
                    out.println("$$End");

                }


                if (s[0].equalsIgnoreCase("makeSearch")){

                    out.println("$$makeSearch");

                    int found = 0;
                    try{
                        found = cd.runMakeSearch(s[1],s[2],out);
                    }catch(IndexOutOfBoundsException e) {
                        out.println("Make and Model CANNOT BE EMPTY");
                        out.println("$$End");
                    }

                    if(found == 0) {
                        out.println( "Not Found! No such car with this Make and Model");

                    }
//
                    out.println("$$End");

                }
                if (s[0].equalsIgnoreCase("buyCar")){

                    out.println("$$buyCar");
                    cd.buyCar(out,s[1]);
                    out.println("$$End");
                }

                if (s[0].equalsIgnoreCase("deleteCar")){

                    out.println("$$deleteCar");
                    cd.deleteCar(out,s[1]);
                    out.println("$$End");
                }

                if (s[0].equalsIgnoreCase("editCar")){

                    out.println("$$editCar");
                    cd.editCar(out,s[1],s[2]);
                    out.println("$$End");
                }

                if (s[0].equalsIgnoreCase("addCar")){

                    out.println("$$addCar");
                    cd.addCar(out,s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    out.println("$$End");
                }
            }
        } catch (IOException|ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
}