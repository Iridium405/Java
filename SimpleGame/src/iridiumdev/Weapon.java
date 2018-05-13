package iridiumdev;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Weapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    //TODO: private int value;

    public Weapon(String name, int minDamage, int maxDamage) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
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
