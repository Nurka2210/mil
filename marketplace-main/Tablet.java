package Factory;

public class Tablet implements Product {
    private int id;
    private String type;
    private int price;

    public Tablet(int id, String type, int price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public String getType() {
        return type;
    }


    public int getPrice() {
        return price;
    }



    @Override
    public void printProductInfo() {
        System.out.println("ID: " + getId() + " Type: " + getType() + " Price: " + getPrice());
    }
}
