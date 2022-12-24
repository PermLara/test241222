package hiber.model;

public class CarTest {

    private int id;

    private String vin;

    private String owner;

    private static int count;

    public CarTest() {
        count++;
        id = count;
        vin = "4J" + Math.round(Math.random() * 100000);
        owner = "Pieter the " + Math.round(Math.random() * 10);
        System.out.println("CarTest{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", owner='" + owner + '\'' +
                '}');

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "CarTest{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
