package iridiumdev;

import java.util.concurrent.ThreadLocalRandom;

public class Weapon {
    private String name;
    private int quantity;
    private int minDamage;
    private int maxDamage;
    //private double value;

    public Weapon(String name, int minDamage, int maxDamage) {
        this.name = name;
        this.quantity = 1;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
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

    public int makeDamage(){
        return ThreadLocalRandom.current().nextInt(this.minDamage,this.maxDamage +1);
    }
}
