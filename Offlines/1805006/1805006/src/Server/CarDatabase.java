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


                temp =line.split(",");
                Car c = new Car (temp[0], Integer.parseInt(temp[1]),temp[2],temp[3],temp[4],temp[5],temp[6], Integer.parseInt(temp[7]) );
                CarID cID = new CarID(c.getMake(),c.getModel());
                quantity.put(cID, quantity.getOrDefault(cID,0) +1);
//
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

    public int runRegSearch(String s){

        String regNum = new String();
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

        String make = ma;
        String model = mo;

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
        for(Car c: carList)
        {
            if(reg.equalsIgnoreCase(c.getReg()))
            {
                out.println("Error: Another car with an Identical Registration Number already Exists.\n Change Registration Number and try again");
                return;
            }

        }
        int yrMade=0, p=0;
        try {
            yrMade = Integer.parseInt(year);
        }catch(NumberFormatException e) {
            out.println("Error: Year Made is not an Integer");
            return;
        }


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

    public void viewCars(PrintWriter out) {
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

    public void editCar(PrintWriter out, String s, String price){

        String reg = s;
        int p = 0;
        try{ p=Integer.parseInt(price);}catch (NumberFormatException e){out.println("Edit unsuccessful: Price Must Be an INTEGER."); return;}
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
            temp.setPrice(p);
            out.println("Price Change Successful!");
        }
    }

    public void buyCar(PrintWriter out, String s)
    {

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
