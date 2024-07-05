package Server;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
class CarID{
    String carMake;
    String carModel;

    public CarID(String make, String model){
        carMake = make.toUpperCase();
        carModel = model.toUpperCase();
    }

    public CarID(Car c){
        carMake = c.getMake().toUpperCase();
        carModel = c.getModel().toUpperCase();
    }


    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof CarID)) {
            return false;
        }

        CarID c = (CarID) o;
        return (carModel.equalsIgnoreCase(c.carModel) && carMake.equalsIgnoreCase(c.carMake));
    }


    @Override
    public int hashCode(){
        int code = 17;
        code = 31 * code + carMake.hashCode();
        code = 31 * code + carModel.hashCode();
        return code;
    }


    @Override
    public String toString() {
        return "Make: " + carMake + ", Model:" + carModel;
    }
}
public class CarDatabase{
    List<Car> carList;
    HashMap<CarID,Integer> quantity;
    Scanner sc;
    String s;
    public CarDatabase(){
        quantity = new HashMap<CarID,Integer>();
        carList = new ArrayList<>();
        sc = new Scanner(System.in);
        s = new String();
    }
    public void readFile(String FileName)
    {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(FileName));
            String temp[];
            while (true) {
                line = br.readLine();
                if (line == null) break;

                //System.out.println(line);

                temp =line.split(",");
                Car c = new Car (temp[0], Integer.parseInt(temp[1]),temp[2],temp[3],temp[4],temp[5],temp[6], Integer.parseInt(temp[7]) );
                CarID cID = new CarID(c.getMake(),c.getModel());
                quantity.put(cID, quantity.getOrDefault(cID,0) +1);
//                System.out.println(c);
//                for(String s: temp){
//                    System.out.print(s+", ");
//                }
//                System.out.println();

                carList.add(c);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeFile(String FileName){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FileName));
            for(Car c: carList){
                String temp = c.toString();
                bw.write(temp);
                bw.write("\n");
            }

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    public int Login(HashMap < String , String> hm, String UID, String Pass) {
////        String UID;
////        String Pass;
//        while(true) {
////                out.println("Enter UserID:");
////                UID = in.readLine();
////                out.println("Enter Password:");
////                Pass = in.readLine();
//            if(UID.equals("viewer") && Pass.equals(""))
//            {
////                    out.println("Welcome Viewer! Please have a look around!!");
//                return 2;
//            }
//            for(String s :hm.keySet())
//            {
//                if(s.equals(UID) && hm.get(s).equals(Pass))
//                {
////                        out.println("Welcome, "+ s);
//                    return 1;
//                }
//            }
////                out.println("Incorrect User ID and Password, Please Try Again");
//            return 0;
//
//        }
//        //return 0; //ONLY REACHES IN CASE OF EXCEPTION;
//    }

    public int runRegSearch(String s){
        //out.println("Enter a Registration number: ");
        String regNum = new String();
//        try {
//            regNum=in.readLine();
//        }catch (IOException e){
//            System.out.println(e);
//        }
        regNum = s;
        int searchIdx =-1;
        for( int i = 0; i < carList.size(); i++){
            Car temp = carList.get(i);
            if(regNum.equalsIgnoreCase(temp.getReg()))
            {
                searchIdx = i;
                break;
            }
        }
        return searchIdx;

    }

    public int runMakeSearch(String ma, String mo, PrintWriter out){

        //out.println("Enter a Make for the car:");
        String make = ma;
//        try {
//            make=in.readLine();
//        }catch (IOException e){
//            System.out.println(e);
//        }

        //out.println("Enter a Model for the car:");
        String model = mo;
//        try {
//            model=in.readLine();
//        }catch (IOException e){
//            System.out.println(e);
//        }

        int found = 0;
        for( Car temp: carList) {
            if(ma.equalsIgnoreCase(temp.getMake()))
            {
                if(mo.equalsIgnoreCase("Any")){
                    temp.display(out);
                    found++;
                }
                else if(mo.equalsIgnoreCase(temp.getModel()))
                {
                    temp.display(out);
                    found++;
                }
            }
        }
        return found;
    }

    public void addCar(PrintWriter out, String reg, String year, String c1, String c2, String c3, String make, String model, String price){
//        out.println("Enter the following details of the Car you want to add:");
//
//        out.println("Registration Number: ");
//        String reg =new String();
//        try {
//            reg=in.readLine();
//        }catch (IOException e){
//            System.out.println(e);
//        }
//        //int searchIdx = -1;
//        int regErr=0;
        for(Car c: carList)
        {
            if(reg.equalsIgnoreCase(c.getReg()))
            {
                out.println("Error: Another car with an Identical Registration Number already Exists.\n Change Registration Number and try again");
//                regErr = 1;
//                break;
                return;
            }
            //out.println(regErr);

        }
        int yrMade=0, p=0;
//        if(regErr==0) {
//
//            out.println("Made in the Year: ");
////            int yrMade = sc.nextInt();
////            sc.nextLine();//since "Enter" after int takes up next sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
        try {
            yrMade = Integer.parseInt(year);
        }catch(NumberFormatException e) {
            out.println("Error: Year Made is not an Integer");
            return;
        }

//            out.println("First Colour: ");
//            //String c1 = sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//            String c1;
//            c1 = s;
//
//            out.println("Second Colour (Leave empty if no Second Colour): ");
//            //String c2 = sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//            String c2;
//            c2 = s;
//
//            out.println("Third Colour (Leave empty if no Third Colour): ");
//            //String c3 = sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//            String c3;
//            c3 = s;
//
//            out.println("Make: ");
//            //String make = sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//            String make;
//            make = s;
//
//            out.println("Model: ");
//            //String model = sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//            String model;
//            model = s;
//
//            out.println("Price: ");
////            int p = sc.nextInt();
////            sc.nextLine();//since "Enter" after int takes up next sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }


        try {
            p = Integer.parseInt(price);
        }catch(NumberFormatException e) {
            out.println("Error: Price is not an Integer");
            return;
        }

            Car newCar = new Car(reg, yrMade, c1, c2, c3, make, model, p);
            carList.add(newCar);
            CarID cID = new CarID(newCar.getMake(),newCar.getModel());
            quantity.put(cID, quantity.getOrDefault(cID,0) +1);
            out.println("Successfully added to Database\n");

        }
    public void deleteCar(PrintWriter out, String s){
//        out.println("Enter the Registration Number of the Car you wish to delete: ");
//        //String reg = sc.nextLine();
//        try {
//            s=in.readLine();
//        }catch (IOException e){
//            System.out.println(e);
//        }
//        String reg;
//        reg = s;
//        int searchIdx = -1;
//        for(int i =0;i<carList.size();i++)
//        {
//            Car temp = carList.get(i);
//            if(reg.equalsIgnoreCase(temp.getReg()))
//            {
//                searchIdx = i;
//                break;
//            }
//        }
//        if(searchIdx == -1) {
//            out.println("Delete unsuccessful: No such Car with this registration number found.");
//        }
//        else{
//            Car c = carList.get(searchIdx);
//            carList.remove(searchIdx);
//            CarID cID = new CarID(c);
//            quantity.put(cID, quantity.getOrDefault(cID,0) -1);
//            if(quantity.get(cID) == 0)      //Comment these out if you want quantities to go 0;
//                quantity.remove(cID);       //
//
//            out.println("Delete Successful");
//        }
        String reg;
        reg = s;
        int searchIdx = -1;
        for(int i =0;i<carList.size();i++)
        {
            Car temp = carList.get(i);
            if(reg.equalsIgnoreCase(temp.getReg()))
            {
                searchIdx = i;
                break;
            }
        }
        if(searchIdx == -1) {
            out.println("Delete unsuccessful: No such Car with this registration number found. Please Try Again");
        }
        else{
            Car c = carList.get(searchIdx);
            carList.remove(searchIdx);
            CarID cID = new CarID(c);
            quantity.put(cID, quantity.getOrDefault(cID,0) -1);
            if(quantity.get(cID) == 0)      //Comment these out if you want quantities to go 0;
                quantity.remove(cID);       //

            out.println("Delete Successful. This car is no longer in Database");
        }
    }

    public void viewCars(PrintWriter out)
    {
        for( Car c: carList){
            out.println("----------------\n");
            c.display(out);
            out.println("----------------\n\n");
        }
        out.println("In Summary: ");
        for(CarID c: quantity.keySet()){
            out.println( c + ", Quantity:" + quantity.get(c));
        }
    }

    public void showQuantities(PrintWriter out){
        for(CarID c: quantity.keySet()){
            out.println( c + "----->Quantity     " + quantity.get(c));
        }
    }

    public void editCar(PrintWriter out, String s, String price){
        //out.println("Enter the Registration Number of the Car you wish to edit: ");
        //String reg = sc.nextLine();
//        try {
//            s=in.readLine();
//        }catch (IOException e){
//            System.out.println(e);
//        }
        String reg = s;
        int p = 0;
        try{ p=Integer.parseInt(price);}catch (NumberFormatException e){e.printStackTrace();}
        int searchIdx = -1;
        for(int i =0;i<carList.size();i++)
        {
            Car temp = carList.get(i);
            if(reg.equalsIgnoreCase(temp.getReg()))
            {
                searchIdx = i;
                break;
            }
        }
        if(searchIdx == -1) {
            out.println("Edit unsuccessful: No such Car with this registration number found.");
        }
        else{
            Car temp = carList.get(searchIdx);
//            out.println("Previous Price: " + temp.getPrice());
//            out.println("Enter your new price: ");
////            int p = sc.nextInt();
////            sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//            int p = Integer.parseInt(s);
            temp.setPrice(p);
            out.println("Price Change Successful!");
        }
    }

    public void buyCar(PrintWriter out, String s)
    {
//        out.println("Enter details of the car you are interested in:");
//        //runMakeSearch(in,out);
//        out.println("Do you wish to buy? (Y/N)"); //Use buttons here
//        //String ans = sc.nextLine();
//        try {
//            s=in.readLine();
//        }catch (IOException e){
//            System.out.println(e);
//        }
//        String ans;
//        ans = s;
//
//        if(ans.equalsIgnoreCase("N")) {
//            out.println("Please do have a look around!");
//        }
//
//        else if(ans.equalsIgnoreCase("Y")){
//            out.println("Enter the Registration Number of the Car you wish to Buy: ");
//            //String reg = sc.nextLine();
//            try {
//                s=in.readLine();
//            }catch (IOException e){
//                System.out.println(e);
//            }
//            String reg;
//            reg = s;
//            int searchIdx = -1;
//            for(int i =0;i<carList.size();i++)
//            {
//                Car temp = carList.get(i);
//                if(reg.equalsIgnoreCase(temp.getReg()))
//                {
//                    searchIdx = i;
//                    break;
//                }
//            }
//            if(searchIdx == -1) {
//                out.println("Buy unsuccessful: No such Car with this registration number found.");
//            }
//            else{
//                Car c = carList.get(searchIdx);
//                carList.remove(searchIdx);
//                CarID cID = new CarID(c);
//                quantity.put(cID, quantity.getOrDefault(cID,0) -1);
//                if(quantity.get(cID) == 0)      //Comment these out if you want quantities to go 0;
//                    quantity.remove(cID);       //
//
//                out.println("Purchase Successful! Thank you and please come again!");
//            }
//        }
        String reg;
        reg = s;
        int searchIdx = -1;
        for(int i =0;i<carList.size();i++)
        {
            Car temp = carList.get(i);
            if(reg.equalsIgnoreCase(temp.getReg()))
            {
                searchIdx = i;
                break;
            }
        }
        if(searchIdx == -1) {
            out.println("Buy unsuccessful: No such Car with this registration number found.");
        }
        else{
            Car c = carList.get(searchIdx);
            carList.remove(searchIdx);
            CarID cID = new CarID(c);
            quantity.put(cID, quantity.getOrDefault(cID,0) -1);
            if(quantity.get(cID) == 0)      //Comment these out if you want quantities to go 0;
                quantity.remove(cID);       //

            out.println("Purchase Successful! Thank you and please come again!");
        }

    }
}
