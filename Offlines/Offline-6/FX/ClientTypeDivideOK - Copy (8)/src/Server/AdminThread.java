package Server;

import java.util.Scanner;
import java.util.HashMap;
public class AdminThread implements Runnable{
    int menu;
    String name;
    String pass;
    Thread t;
    HashMap<String,String> IDs;
    Scanner sc;
    public AdminThread(Scanner sc, HashMap<String, String> hm)
    {
        String name = new String();
        String pass = new String();
        IDs = hm;
        this. sc = sc;
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        while(true){
            System.out.println("\n[ADMIN] -----Admin Privileges-----");
            System.out.println("[ADMIN] 1-> View all Manufacturers");
            System.out.println("[ADMIN] 2-> Add new Manufacturer");
            System.out.println("[ADMIN] 3-> Delete Manufacturer");
            System.out.println("[ADMIN] ------------------------\n");
            menu = sc.nextInt();
            sc.nextLine();
            if(menu == 1) {
                int count = 1;
                System.out.println("\n[ADMIN] ------------------------\n");
                for(String s: IDs.keySet())
                {
                    System.out.println("[ADMIN] "+ count+") Manufacturer: "+s+", Password: "+ IDs.get(s));
                    count++;
                }
                System.out.println("\n[ADMIN] ------------------------\n");
            }
            else if(menu == 2){
                System.out.println("[ADMIN] Enter Name of Manufacturer you want to add:");
                name = sc.nextLine();
                int count = 0;
                for(String s: IDs.keySet())
                {
                    if(s.equals(name))
                    count++;
                }
                if(count == 0) {
                    System.out.println("[ADMIN] Enter Password: ");
                    pass = sc.nextLine();
                    IDs.put(name, pass);
                    System.out.println("\n[ADMIN] ----Addition Successful----\n");
                }
                else
                {
                    System.out.println("[ADMIN] ----Error! Pre-existing  Manufacturer with same name----");
                }
            }
            else if (menu == 3){
                System.out.println("[ADMIN] Enter Name of Manufacturer you want to delete:");
                name = sc.nextLine();
                int count = 0;
                for(String s: IDs.keySet())
                {
                    if(s.equals(name))
                        count++;
                }
                if(count == 0){
                    System.out.println("[ADMIN] ----Error! No Manufacturer with this name----");
                }
                else {
                    IDs.remove(name);
                    System.out.println("\n[ADMIN] ----Delete Successful----\n");
                }
            }
            else if(menu == -1){
                System.out.println("[ADMIN] ----Exiting Admin Panel----\n");
                break;
            }

        }
    }
}
