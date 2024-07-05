package ServerSide;
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
    private int user;



    public ClientHandler(Socket s, CarDatabase cd, HashMap hm){

        IDs = hm;
        this.client = s;
        this.cd = cd;
        user = 0;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    @Override
    public void run() {
        try{
            user= cd.Login(IDs, in, out);
        while(true){
            int mainMenu= cd.runMainMenu(in, out, user );
            if(mainMenu != 1 && mainMenu != 2 && mainMenu != 3 && mainMenu != 4 && mainMenu != 5 && mainMenu != 6){
                out.println("Invalid Main Menu input\nEnter Options 1 to 5");
                continue;
            }
            if(mainMenu==6){
                break;
            }
            if(mainMenu == 1)
            {
                cd.viewCars(out);
            }
            else if(mainMenu == 2){
                cd.showQuantities(out);
            }
            else if(mainMenu == 3 && user == 2){
                int searchIdx = cd.runRegSearch(in, out);

                if(searchIdx == -1) {
                    out.println( "Not Found! No such car with this Registration Number");
                    //continue;
                }
                else {
                    Car temp = cd.carList.get(searchIdx);
                    temp.display(out);
                }
            }

            else if( mainMenu == 4 && user== 2 )
            {

                int found = cd.runMakeSearch(in, out);
                if(found==0)
                    out.println("Not Found! No such Car with this Car Make and Car Model");

            }
            else if(mainMenu == 5 && user == 2){
                cd.buyCar(in, out);
            }

            else if(mainMenu == 3 && user == 1){

                cd.addCar(in, out);
            }

            else if(mainMenu == 5 && user == 1)
            {
                cd.deleteCar(in, out);
            }
            else if(mainMenu == 4 && user==1){
                cd.editCar(in, out);
            }

//            if(mainMenu==1){
//                while(true) {
//                    int searchMenu = cd.runSearchCars(in, out);
//
//                    if (searchMenu != 1 && searchMenu != 2 && searchMenu != 3) {
//                        out.println("Invalid Search Option\nEnter an option between 1,2 or 3");
//                        continue;
//                    }
//
//                    if(searchMenu == 3){
//                        break;
//                    }
//
//                    if(searchMenu == 1){
//                        int searchIdx = cd.runRegSearch(in, out);
//
//                        if(searchIdx == -1) {
//                            out.println( "Not Found! No such car with this Registration Number");
//                            continue;
//                        }
//                        else {
//                            Car temp = cd.carList.get(searchIdx);
//                            temp.display(out);
//                        }
//                    }
//
//                    else if( searchMenu == 2 )
//                    {
//
//                        int found = cd.runMakeSearch(in, out);
//                        if(found==0)
//                            out.println("Not Found! No such Car with this Car Make and Car Model");
//
//                    }
//
//                }
//
//            }





//            else if(mainMenu == 4)
//            {
//                cd.viewCars(out);
//            }





        }}catch(Exception e){
            System.out.println(e);
        }
        finally {
            out.println("Close"); //IMPRTANT FOR CLOSING, CLIENT LINE 29
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            cd.writeFile(Main.FILE_NAME);
            //out.println("Close2");

        }


    }
}
