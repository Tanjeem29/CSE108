import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        return "CarID{" +
                "carMake='" + carMake + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}
public class CarDatabase{
    List<Car> carList;
    HashMap<CarID,Integer> quantity;
    Scanner sc;
    public CarDatabase(){
        quantity = new HashMap<CarID,Integer>();
        carList = new ArrayList<>();
        sc = new Scanner(System.in);
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

    public int runMainMenu()
    {
        int mainMenu;

        System.out.println("(1) Search Cars");
        System.out.println("(2) Add Car");
        System.out.println("(3) Delete Cars");
        System.out.println("(4) View All Cars");
        System.out.println("(5) Show Quantities");
        System.out.println("(6) Edit Car");
        System.out.println("(7) Buy Car");
        System.out.println("(8) Exit System");

        mainMenu =sc.nextInt();
        sc.nextLine();//since "Enter" after int takes up next sc.nextLine();
        return mainMenu;
    }
    public int runSearchCars()
    {
        int searchMenu;

        System.out.println("(1) Search By Registration Number");
        System.out.println("(2) Search By Car Make and Car Model");
        System.out.println("(3) Back to Main Menu");

        searchMenu = sc.nextInt();
        sc.nextLine();//since "Enter" after int takes up next sc.nextLine();
        return searchMenu;
    }
    public int runRegSearch(){
        System.out.println("Enter a Registration number: ");
        String regNum = sc.nextLine();
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

    public int runMakeSearch(){
        System.out.println("Enter a Make for the car:");
        String make = sc.nextLine();
        System.out.println("Enter a Model for the car:");
        String model = sc.nextLine();
        int found = 0;
        for( Car temp: carList) {
            if(make.equalsIgnoreCase(temp.getMake()))
            {
                if(model.equalsIgnoreCase("Any")){
                    temp.display();
                    found++;
                }
                else if(model.equalsIgnoreCase(temp.getModel()))
                {
                    temp.display();
                    found++;
                }
            }
        }
        return found;
    }

    public void addCar(){
        System.out.println("Enter the following details of the Car you want to add:");

        System.out.print("Registration Number: ");
        String reg =sc.nextLine();
        //int searchIdx = -1;
        int regErr=0;
        for(Car c: carList)
        {
            if(reg.equalsIgnoreCase(c.getReg()))
            {
                System.out.println("Error: Another car with an Identical Registration Number already Exists.");
                regErr = 1;
                break;
            }

        }
        if(regErr==0) {

            System.out.print("Made in the Year: ");
            int yrMade = sc.nextInt();
            sc.nextLine();//since "Enter" after int takes up next sc.nextLine();

            System.out.print("First Colour: ");
            String c1 = sc.nextLine();

            System.out.print("Second Colour (Leave empty if no Second Colour): ");
            String c2 = sc.nextLine();

            System.out.print("Third Colour (Leave empty if no Third Colour): ");
            String c3 = sc.nextLine();

            System.out.print("Make: ");
            String make = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("Price: ");
            int p = sc.nextInt();
            sc.nextLine();//since "Enter" after int takes up next sc.nextLine();


            Car newCar = new Car(reg, yrMade, c1, c2, c3, make, model, p);
            carList.add(newCar);
            CarID cID = new CarID(newCar.getMake(),newCar.getModel());
            quantity.put(cID, quantity.getOrDefault(cID,0) +1);
            System.out.println("Successfully added to Database\n");

        }
    }
    public void deleteCar(){
        System.out.print("Enter the Registration Number of the Car you wish to delete: ");
        String reg = sc.nextLine();
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
            System.out.println("Delete unsuccessful: No such Car with this registration number found.");
        }
        else{
            Car c = carList.get(searchIdx);
            carList.remove(searchIdx);
            CarID cID = new CarID(c);
            quantity.put(cID, quantity.getOrDefault(cID,0) -1);
            if(quantity.get(cID) == 0)      //Comment these out if you want quantities to go 0;
                quantity.remove(cID);       //

            System.out.println("Delete Successful");
        }
    }

    public void viewCars()
    {
        for( Car c: carList){
            System.out.println("----------------\n");
            c.display();
            System.out.println("----------------\n\n");
        }
    }

    public void showQuantities(){
        for(CarID c: quantity.keySet()){
            System.out.println( c + "----->Quantity     " + quantity.get(c));
        }
    }

    public void editCar(){
        System.out.print("Enter the Registration Number of the Car you wish to edit: ");
        String reg = sc.nextLine();
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
            System.out.println("Edit unsuccessful: No such Car with this registration number found.");
        }
        else{
            Car temp = carList.get(searchIdx);
            System.out.println("Previous Price: " + temp.getPrice());
            System.out.println("Enter your new price: ");
            int p = sc.nextInt();
            sc.nextLine();
            temp.setPrice(p);
            System.out.println("Price Change Successful!");
        }
    }

    public void buyCar()
    {
        System.out.println("Enter details of the car you are interested in:");
        runMakeSearch();
        System.out.println("Do you wish to buy? (Y/N)"); //Use buttons here
        String ans = sc.nextLine();

        if(ans.equalsIgnoreCase("N")) {
            System.out.println("Please do have a look around!");
        }

        else if(ans.equalsIgnoreCase("Y")){
            System.out.print("Enter the Registration Number of the Car you wish to Buy: ");
            String reg = sc.nextLine();
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
                System.out.println("Buy unsuccessful: No such Car with this registration number found.");
            }
            else{
                Car c = carList.get(searchIdx);
                carList.remove(searchIdx);
                CarID cID = new CarID(c);
                quantity.put(cID, quantity.getOrDefault(cID,0) -1);
                if(quantity.get(cID) == 0)      //Comment these out if you want quantities to go 0;
                    quantity.remove(cID);       //

                System.out.println("Purchase Successful! Thank you and please come again!");
            }
        }

    }
}
