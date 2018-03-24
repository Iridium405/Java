package iridiumdev;

import java.util.concurrent.ThreadLocalRandom;

public class Weapon {
    private String name;
    private String type;
    private int quantity;
    private int minDamage;
    private int maxDamage;
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

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int makeDamage(){ //makeDamage - atak fizyczny VS. conjureDamage - atak energetyczny
        return ThreadLocalRandom.current().nextInt(this.minDamage,this.maxDamage +1);
    }
}
