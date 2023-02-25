package Factory;

public class Powerbank implements Product{
    private int id;
    private int volume;
    private int price;

    public Powerbank(int id, int volume, int price) {
        this.id = id;
        this.volume = volume;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public int getVolume() {
        return volume;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public void printProductInfo() {
        System.out.println("ID: " + getId() + " Volume: " + getVolume() + " Price: " + getPrice());
    }
}
