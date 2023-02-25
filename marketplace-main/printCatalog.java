package Factory;

import Singleton.DatabaseSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class printCatalog {
    static DatabaseSingleton db = DatabaseSingleton.getInstance();
    static Scanner scanner = new Scanner(System.in);

    public static void showCat(int cat) throws SQLException {
        db.connect();
        if (cat == 1){
            ArrayList<Product> phones = new ArrayList<>();
            System.out.println("1. Apple");
            System.out.println("2. Samsung");
            System.out.println("3. Xiaomi");
            System.out.println("4. Exit");
            System.out.println("Choose brand:");
            int c = scanner.nextInt();
            String brand = "";
            switch (c){
                case 1: brand = "Apple";break;
                case 2: brand = "Samsung";break;
                case 3: brand = "Xiaomi";break;
            }
            ResultSet r = db.result("select * from phones where brand='"+brand+"'");
            while (r.next()){
                Phone phone = new Phone(r.getInt("id"), r.getString("brand"), r.getString("model"), r.getInt("rom"), r.getString("color"), r.getInt("price"));
                phones.add(phone);
            }
            for (Product product : phones){
                product.printProductInfo();
            }
        }
        else if (cat == 2) {
            ArrayList<Product> tablets = new ArrayList<>();
            ResultSet r = db.result("select * from tablets");
            while (r.next()){
                Tablet tablet = new Tablet(r.getInt("id"), r.getString("type"),r.getInt("price"));
                tablets.add(tablet);
            }
            for(Product product : tablets){
                product.printProductInfo();
            }
        }
        else if(cat == 3){
            ArrayList<Product> chargers = new ArrayList<>();
            ResultSet r = db.result("select * from charger");
            while (r.next()){
                Charger charger = new Charger(r.getInt("id"),r.getDouble("length"),r.getInt("price"),r.getString("type"));
                chargers.add(charger);
            }
            for(Product product : chargers){
                product.printProductInfo();
            }
        }
        else if (cat == 4) {
            ArrayList<Product> powerbanks = new ArrayList<>();
            ResultSet r = db.result("select * from charger");
            while (r.next()){
                Powerbank powerbank = new Powerbank(r.getInt("id"),r.getInt("volume"),r.getInt("price"));
                powerbanks.add(powerbank);
            }
            for(Product product : powerbanks){
                product.printProductInfo();
            }
        }
        else {
            System.out.println("ERROR: Category does not exist");
        }
    }
}
