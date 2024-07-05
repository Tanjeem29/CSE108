import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class CarDatabase{
    List<Car> carList;
    Scanner sc;
    public CarDatabase(){
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
        System.out.println("(5) Exit System");

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
            carList.remove(searchIdx);
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
}
