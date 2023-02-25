package Utility;

import java.sql.ResultSet;
import java.util.Scanner;
import Singleton.*;
import Market.*;
import Factory.*;
public class um implements ui {

    DatabaseSingleton db = DatabaseSingleton.getInstance();
    Scanner scanner = new Scanner(System.in);
    int ubalance = 0;
    @Override
    public void addUser(String name, int balance) throws Exception {
        db.connect();
        ubalance = balance;
        db.execute("insert into users(name,balance) values('"+name+"','"+balance+"');");
        /*db.disconnect();*/
    }
    @Override
    public void purchaseInfo(int id) throws Exception {
        db.connect();
        ResultSet r = db.result("select * from purchases where userid='"+id+"'");
        while (r.next()){
            System.out.println("Receipt ID: "+r.getInt("id")+" Total: "+r.getInt("total")+" User ID: "+r.getInt("userid"));
        }
        /*db.disconnect();*/
    }
    @Override
    public void catalog() throws Exception {
        int c;
        do{
            System.out.println("1. Phones");
            System.out.println("2. Tablets");
            System.out.println("3. Chargers");
            System.out.println("4. Powerbanks");
            System.out.println("5. Exit");

            c = scanner.nextInt();

            printCatalog.showCat(c);
            break;

        }while(c!=5);
    }
    @Override
    public void purchase(int id) throws Exception {
        db.connect();
        System.out.println("Choose category");
        System.out.println("1.Phone");
        System.out.println("2.Tablet");
        System.out.println("3.Charger");
        System.out.println("4.Powerbank");
        int cat = scanner.nextInt();
        int remainder = 0;
        int price=0;
        ubalance = getBalance.giveBalance(id);
        switch (cat){
            case 1:
                printCatalog.showCat(cat);
                System.out.println("Enter product id: ");
                int pid1 = scanner.nextInt();
                
                ResultSet r = db.result("select price from phones where id = '"+pid1+"'");
                if(r.next()){
                    price = r.getInt("price");
                }
                remainder = ubalance - price;
                db.execute("update users set balance='"+remainder+"' where id='"+id+"'");
                db.execute("insert into purchases(userid,total) values('"+id+"','"+price+"');");
              
                receipt(id);
                break;
            case 2:
                printCatalog.showCat(cat);
                System.out.println("Enter product id: ");
                int pid2 = scanner.nextInt();
                ResultSet r2 = db.result("select price from tablets where id = '"+pid2+"'");
                if(r2.next()){
                    price = r2.getInt("price");
                }
                remainder = ubalance - price;
                db.execute("update users set balance='"+remainder+"' where id='"+id+"'");
                db.execute("insert into purchases(userid,total) values('"+id+"','"+price+"');");
              
                receipt(id);
                break;
            case 3:
                printCatalog.showCat(cat);
                System.out.println("Enter product id: ");
                int pid3 = scanner.nextInt();
                ResultSet r3 = db.result("select price from charger where id = '"+pid3+"'");
                if(r3.next()){
                    price = r3.getInt("price");
                }
                remainder = ubalance - price;
                db.execute("update users set balance='"+remainder+"' where id='"+id+"'");
                db.execute("insert into purchases(userid,total) values('"+id+"','"+price+"');");
              
                receipt(id);
                break;
            case 4:
                printCatalog.showCat(cat);
                System.out.println("Enter product id: ");
                int pid4 = scanner.nextInt();
                ResultSet r4 = db.result("select price from powerbank where id = '"+pid4+"'");
                if(r4.next()){
                    price = r4.getInt("price");
                }
                remainder = ubalance - price;
                db.execute("update users set balance='"+remainder+"' where id='"+id+"'");
                db.execute("insert into purchases(userid,total) values('"+id+"','"+price+"');");
              
                receipt(id);
                break;    
        }
    }
    @Override
    public void userInfo(int id) throws Exception {
        db.connect();
        ResultSet r = db.result("select * from users where id='"+id+"'");
        if (r.next()){
            System.out.println("ID: "+r.getInt("id")+" Name: "+r.getString("name")+" Balance: "+r.getInt("balance"));
        }
    }

    @Override
    public void receipt(int id) throws Exception {
        db.connect();
        ResultSet r = db.result("SELECT * FROM purchases WHERE userid='"+id+"' ORDER BY id DESC LIMIT 1");
        if(r.next()){
            System.out.println("Receipt ID: "+r.getInt("id")+" Total: "+r.getInt("total")+" User ID: "+r.getInt("userid"));
        }
    }
}