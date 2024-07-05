//import java.util.ArrayList;
//import java.util.List;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        final String FILE_NAME = "in.txt";              //change to cars.txt as per question
//        CarDatabase cd = new CarDatabase();
//        cd.readFile(FILE_NAME);
//
//        //Scanner sc = new Scanner(System.in);
////        for(Car t: carList){
////            System.out.println(t);
////        }
//
//        while(true){
//            int mainMenu= cd.runMainMenu();
//            if(mainMenu != 1 && mainMenu != 2 && mainMenu != 3 && mainMenu != 4 && mainMenu != 5 && mainMenu != 6 && mainMenu != 7 && mainMenu != 8){
//                System.out.println("Invalid Main Menu input\nEnter Options 1 to 8");
//                continue;
//            }
//            if(mainMenu==8){
//                break;
//            }
//            if(mainMenu==1){
//                while(true) {
//                    int searchMenu = cd.runSearchCars();
//
//                    if (searchMenu != 1 && searchMenu != 2 && searchMenu != 3) {
//                        System.out.println("Invalid Search Option\nEnter an option between 1,2 or 3");
//                        continue;
//                    }
//
//                    if(searchMenu == 3){
//                        break;
//                    }
//
//                    if(searchMenu == 1){
//                        int searchIdx = cd.runRegSearch();
//
//                        if(searchIdx == -1) {
//                            System.out.println( "Not Found! No such car with this Registration Number");
//                            continue;
//                        }
//                        else {
//                            Car temp = cd.carList.get(searchIdx);
//                            temp.display();
//                        }
//                    }
//
//                    else if( searchMenu == 2 )
//                    {
//
//                        int found = cd.runMakeSearch();
//                        if(found==0)
//                            System.out.println("Not Found! No such Car with this Car Make and Car Model");
//
//                    }
//
//                }
//
//            }
//
//            else if(mainMenu == 2){
//
//                cd.addCar();
//            }
//
//            else if(mainMenu == 3)
//            {
//                cd.deleteCar();
//            }
//
//            else if(mainMenu == 4)
//            {
//                cd.viewCars();
//            }
//            else if(mainMenu == 5){
//                cd.showQuantities();
//            }
//            else if(mainMenu == 6){
//                cd.editCar();
//            }
//            else if(mainMenu == 7){
//                cd.buyCar();
//            }
//
//
//        }
//
//        cd.writeFile(FILE_NAME);
//    }
//}
