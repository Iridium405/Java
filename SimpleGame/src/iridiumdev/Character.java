package iridiumdev;

import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int hitPoints;
    private int energy;
    private int stamina;
    private int money;
    private int skillPoint;
    private int expGivenWhenDead;
    private int strength;
    private int defence;
    private int quickness;
    private int power;
    private int protection;
    private int focus;
    private boolean isAlive;
    private boolean isEnemy;

    public Character(String name, int hitPoints, int energy, int stamina, int skillPoint,
                     int strength, int defence, int quickness, int power, int protection, int focus, boolean isAlive) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.energy = energy;
        this.stamina = stamina;
        this.skillPoint = skillPoint;
        this.strength = strength;
        this.defence = defence;
        this.quickness = quickness;
        this.power = power;
        this.protection = protection;
        this.focus = focus;
        this.isAlive = isAlive;
    }

    public Character(boolean isEnemy, String name, int hitPoints, int energy, int stamina, int expGivenWhenDead, int strength,
                     int defence, int quickness, int power, int protection, int focus, boolean isAlive) {
        this.isAlive = isAlive;
        this.name = name;
        this.hitPoints = hitPoints;
        this.energy = energy;
        this.stamina = stamina;
        this.expGivenWhenDead = expGivenWhenDead;
        this.strength = strength;
        this.defence = defence;
        this.quickness = quickness;
        this.power = power;
        this.protection = protection;
        this.focus = focus;
        this.isEnemy = isEnemy;
    }

    public Character(int money, String name, int hitPoints, int energy, int stamina, int expGivenWhenDead, int strength,
                     int defence, int quickness, int power, int protection, int focus, boolean isAlive, boolean isEnemy) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.energy = energy;
        this.stamina = stamina;
        this.money = money;
        this.expGivenWhenDead = expGivenWhenDead;
        this.strength = strength;
        this.defence = defence;
        this.quickness = quickness;
        this.power = power;
        this.protection = protection;
        this.focus = focus;
        this.isAlive = isAlive;
        this.isEnemy = isEnemy;
    }

    ArrayList<Item> equipment = new ArrayList<Item>();

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMoney() {
        return money;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public int getExpGivenWhenDead() {
        return expGivenWhenDead;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefence() {
        return defence;
    }

    public int getQuickness() {
        return quickness;
    }

    public int getPower() {
        return power;
    }

    public int getProtection() {
        return protection;
    }

    public int getFocus() {
        return focus;
    }

    public boolean isAlive() {
        if(this.hitPoints <= 0){
            return false;
        } else {
            return true;
        }
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public int higherStat(int characterStat_1, int characterStat_2){
        if(characterStat_1 >= characterStat_2){
            return characterStat_1;
        } else {
            return characterStat_2;
        }
    } // method tested.
}
