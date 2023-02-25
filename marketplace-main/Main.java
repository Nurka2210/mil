package Market;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n;
        do{
            System.out.println("1. Add User");
            System.out.println("2. Catalog");
            System.out.println("3. Make a purchase");
            System.out.println("4. Profile");
            System.out.println("5. History");
            System.out.println("6. Exit");
            n = scanner.nextInt();
            switch (n) {
                case 1 -> marketSystem.addUser();
                case 2 -> marketSystem.catalog();
                case 3 -> marketSystem.purchase();
                case 4 -> marketSystem.userInfo();
                case 5 -> marketSystem.history();

                default -> {
                }
            }

        }while(n!=6);
    }
}