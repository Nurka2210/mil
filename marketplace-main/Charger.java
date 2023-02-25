package Factory;

public class Charger implements Product{
    private int id;
    private double length;
    private int price;
    private String type;

    public Charger(int id, double length, int price, String type) {
        this.id = id;
        this.length = length;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public double getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public void printProductInfo() {
        System.out.println("ID: " + getId() + " Type: " + getType() + " Price: " + getPrice() + " Length: "+getLength());
    }
}
