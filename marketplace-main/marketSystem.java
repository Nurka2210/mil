package Market;

import java.util.Scanner;
import Utility.*;
public class marketSystem {
    static Scanner scanner = new Scanner(System.in);
    static int uid = 0;
    static ui u = new um();
    public static void addUser() throws Exception{
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Balance:");
        int balance = scanner.nextInt();
        u.addUser(name,balance);
        uid = getID.giveID(name);
    }
    public static void catalog() throws Exception{
        u.catalog();
    }
    public static void history() throws Exception{
        u.purchaseInfo(uid);
    }
    public static void purchase() throws Exception{
        u.purchase(uid);
    }
    public static void userInfo() throws Exception{
        u.userInfo(uid);
    }

}
