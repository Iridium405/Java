package iridiumdev;

import java.util.concurrent.ThreadLocalRandom;

public class Weapon {
    private String name;
    private String type;
    private int quantity;
    private double minDamage;
    private double maxDamage;
    //TODO: private double value;

    public Weapon(String name, int minDamage, int maxDamage) {
        this.name = name;
        this.type = "Weapon";
        this.quantity = 1;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
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

    public double getMinDamage() {
        return minDamage;
    }

    public double getMaxDamage() {
        return maxDamage;
    }

    public double makeDamage(){ //makeDamage - atak fizyczny VS. conjureDamage - atak energetyczny
        return ThreadLocalRandom.current().nextDouble(this.minDamage,this.maxDamage +1);
    }
}
