package iridiumdev;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Weapon {
    private String name;
    private String type;
    private int physicalQuality;
    private int magicalQuality;
    private int minDamage;
    private int maxDamage;
    private int damageMade;
    //TODO: private int value;


    public Weapon(String name, String type, int physicalQuality, int magicalQuality, int minDamage, int maxDamage) {
        this.name = name;
        this.type = type;
        this.physicalQuality = physicalQuality;
        this.magicalQuality = magicalQuality;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPhysicalQuality() {
        return physicalQuality;
    }

    public int getMagicalQuality() {
        return magicalQuality;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getDamageMade() {
        return damageMade;
    }

    public int makeDamage(){ //makeDamage - atak fizyczny VS. conjureDamage - atak energetyczny
        return damageMade = ThreadLocalRandom.current().nextInt(this.minDamage,this.maxDamage +1);
    }
}
