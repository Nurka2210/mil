package Factory;

public class Phone implements Product {
    private int id;
    private String brand;
    private String model;
    private int rom;
    private String color;
    private int price;

    public Phone(int id, String brand, String model, int rom, String color, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.rom = rom;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }



    public String getModel() {
        return model;
    }



    public int getRom() {
        return rom;
    }


    public String getColor() {
        return color;
    }


    public int getPrice() {
        return price;
    }


    @Override
    public void printProductInfo() {
        System.out.println("ID: " + getId() + " Brand: " + getBrand() + " Model: " + getModel() + " Memory: " + getRom() + " Color: " + getColor() + " Price: " + getPrice());
    }
}
