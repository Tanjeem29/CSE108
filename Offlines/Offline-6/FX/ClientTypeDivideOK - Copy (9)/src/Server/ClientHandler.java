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
//            while(true){
////                int mainMenu= cd.runMainMenu(in, out );
////                if(mainMenu != 1 && mainMenu != 2 && mainMenu != 3 && mainMenu != 4 && mainMenu != 5 && mainMenu != 6 && mainMenu != 7 && mainMenu != 8){
////                    out.println("Invalid Main Menu input\nEnter Options 1 to 8");
////                    continue;
////                }
////                if(mainMenu==8){
////                    break;
////                }
//                String Cmd = out.println();
//                /*if(mainMenu==1){
//                    while(true) {
//                        int searchMenu = cd.runSearchCars(in, out);
//
//                        if (searchMenu != 1 && searchMenu != 2 && searchMenu != 3) {
//                            out.println("Invalid Search Option\nEnter an option between 1,2 or 3");
//                            continue;
//                        }
//
//                        if(searchMenu == 3){
//                            break;
//                        }
//
//                        if(searchMenu == 1){
//                            int searchIdx = cd.runRegSearch(in, out);
//
//                            if(searchIdx == -1) {
//                                out.println( "Not Found! No such car with this Registration Number");
//                                continue;
//                            }
//                            else {
//                                Car temp = cd.carList.get(searchIdx);
//                                temp.display(out);
//                            }
//                        }
//
//                        else if( searchMenu == 2 )
//                        {
//
//                            int found = cd.runMakeSearch(in, out);
//                            if(found==0)
//                                out.println("Not Found! No such Car with this Car Make and Car Model");
//
//                        }
//
//                    }
//
//                }
//
//                else if(mainMenu == 2){
//
//                    cd.addCar(in, out);
//                }
//
//                else if(mainMenu == 3)
//                {
//                    cd.deleteCar(in, out);
//                }
//
//                else if(mainMenu == 4)
//                {
//                    cd.viewCars(out);
//                }
//                else if(mainMenu == 5){
//                    cd.showQuantities(out);
//                }
//                else if(mainMenu == 6){
//                    cd.editCar(in, out);
//                }
//                else if(mainMenu == 7){
//                    cd.buyCar(in, out);
//                }
//
//
//            }}catch(Exception e){
//            System.out.println(e);
//        }*/
//        finally {
//            out.println("Close");
//            out.close();
//            try {
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            cd.writeFile(Server.FILE_NAME);
//
//        }
//
//
//    }
            while (true) {
                String cmd = in.readLine();
                String[] s = cmd.split(":");
                //System.out.println(cmd);
                if (s[0].equalsIgnoreCase("IDsReq")) {
                    new IDThread(IDs, client, in, out);
                    //break;
                }
                if (s[0].equalsIgnoreCase("viewAll")) {
                    out.println("$$viewAll");
                    cd.viewCars(out);
                    out.println("$$End");
                    //break;
                }
                if (s[0].equalsIgnoreCase("regSearch")){
                    //throw new IOException();

                    out.println("$$regSearch");
                    int searchIdx = cd.runRegSearch(s[1]);
                    //out.println(Integer.toString(searchIdx));
                    if(searchIdx == -1) {
                        out.println( "Not Found! No such car with this Registration Number");
                        //continue;
                    }
                    else {
                        Car temp = cd.carList.get(searchIdx);
                        temp.display(out);
                    }
                    out.println("$$End");
                    //break;
                }
                if (s[0].equalsIgnoreCase("makeSearch")){
                    //throw new IOException();

                    out.println("$$makeSearch");
                    int found = cd.runMakeSearch(s[1],s[2],out);
                    //out.println(Integer.toString(searchIdx));
                    if(found == 0) {
                        out.println( "Not Found! No such car with this Make and Model");
                        //continue;
                    }
//                    else {
//                        Car temp = cd.carList.get(searchIdx);
//                        temp.display(out);
//                    }
                    out.println("$$End");
                    //break;
                }
                if (s[0].equalsIgnoreCase("buyCar")){
                    //throw new IOException();

                    out.println("$$buyCar");
                    cd.buyCar(out,s[1]);
                    //try{ Thread.sleep(200);}catch (Exception e){}
//                    int searchIdx = cd.runRegSearch(s[1]);
//                    //out.println(Integer.toString(searchIdx));
//                    if(searchIdx == -1) {
//                        out.println( "Not Found! No such car with this Registration Number");
//                        //continue;
//                    }
//                    else {
//                        Car temp = cd.carList.get(searchIdx);
//                        temp.display(out);
//                    }
                    out.println("$$End");
                    //break;
                }
                if (s[0].equalsIgnoreCase("deleteCar")){
                    //throw new IOException();

                    out.println("$$deleteCar");
                    cd.deleteCar(out,s[1]);
                    //try{ Thread.sleep(200);}catch (Exception e){}
//                    int searchIdx = cd.runRegSearch(s[1]);
//                    //out.println(Integer.toString(searchIdx));
//                    if(searchIdx == -1) {
//                        out.println( "Not Found! No such car with this Registration Number");
//                        //continue;
//                    }
//                    else {
//                        Car temp = cd.carList.get(searchIdx);
//                        temp.display(out);
//                    }
                    out.println("$$End");
                    //break;
                }
                if (s[0].equalsIgnoreCase("editCar")){
                    //throw new IOException();

                    out.println("$$editCar");
                    cd.editCar(out,s[1],s[2]);
                    //try{ Thread.sleep(200);}catch (Exception e){}
//                    int searchIdx = cd.runRegSearch(s[1]);
//                    //out.println(Integer.toString(searchIdx));
//                    if(searchIdx == -1) {
//                        out.println( "Not Found! No such car with this Registration Number");
//                        //continue;
//                    }
//                    else {
//                        Car temp = cd.carList.get(searchIdx);
//                        temp.display(out);
//                    }
                    out.println("$$End");
                    //break;
                }
                if (s[0].equalsIgnoreCase("addCar")){
                    //throw new IOException();

                    out.println("$$addCar");
                    cd.addCar(out,s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    //try{ Thread.sleep(200);}catch (Exception e){}
//                    int searchIdx = cd.runRegSearch(s[1]);
//                    //out.println(Integer.toString(searchIdx));
//                    if(searchIdx == -1) {
//                        out.println( "Not Found! No such car with this Registration Number");
//                        //continue;
//                    }
//                    else {
//                        Car temp = cd.carList.get(searchIdx);
//                        temp.display(out);
//                    }
                    out.println("$$End");
                    //break;
                }
            }
        } catch (IOException|ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
}