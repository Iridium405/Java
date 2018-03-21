package iridiumdev;

public class Armour {
    private String name;
    private String type;
    private int quantity;
    private int defence;
    private int protection;
    //TODO: private double value;


    public Armour(String name, int defence, int protection) {
        this.name = name;
        this.type = "Armour";
        this.quantity = 1;
        this.defence = defence;
        this.protection = protection;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDefence() {
        return defence;
    }

    public int getProtection() {
        return protection;
    }
}
