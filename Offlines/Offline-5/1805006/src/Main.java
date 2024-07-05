import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String FILE_NAME = "in.txt"; //change to cars.txt as per question
        List<Car> carList = new ArrayList();
        CarDatabase.readFile(carList, FILE_NAME);
        Scanner sc = new Scanner(System.in);
//        for(Car t: carList){
//            System.out.println(t);
//        }

        while(true){
            System.out.println("(1) Search Cars");
            System.out.println("(2) Add Car");
            System.out.println("(3) Delete Cars");
            System.out.println("(4) Exit System");

            int mainMenu =sc.nextInt();
            sc.nextLine();//since "Enter" after int takes up next sc.nextLine();
            if(mainMenu < 1||mainMenu > 4){
                System.out.println("Invalid Main Menu input\nEnter Options 1 to 4");
                continue;
            }
            if(mainMenu==4){
                break;
            }
            if(mainMenu==1){
                while(true) {
                    System.out.println("(1) Search By Registration Number");
                    System.out.println("(2) Search By Car Make and Car Model");
                    System.out.println("(3) Back to Main Menu");

                    int searchMenu = sc.nextInt();
                    sc.nextLine();//since "Enter" after int takes up next sc.nextLine();
                    if (searchMenu < 1 || searchMenu > 3) {
                        System.out.println("Invalid Search Option\nEnter an option between 1,2 or 3");
                        continue;
                    }
                    if(searchMenu == 3){
                        break;
                    }
                    if(searchMenu == 1){
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

                        if(searchIdx == -1) {
                            System.out.println( "Not Found! No such car with this Registration Number");
                            continue;
                        }
                        else {
                            Car temp = carList.get(searchIdx);
                            temp.display();
                        }
                    }
                    else if( searchMenu == 2 )
                    {

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
                        if(found==0)
                            System.out.println("Not Found! No such Car with this Car Make and Car Model");

                    }

                }

            }
            else if(mainMenu == 2){

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
            else if(mainMenu == 3)
            {
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





        }

        CarDatabase.writeFile(carList, FILE_NAME);
    }
}
