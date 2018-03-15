package iridiumdev;

import java.util.ArrayList;

public abstract class Character {
    private String name;
    private double hitPoints;
    private double energy;
    private double stamina;
    private int level;
    private int experience;
    private int expGivenWhenDead;
    private int strength;
    private int defence;
    private int quickness;
    private int power;
    private int protection;
    private int focus;
    private String affinity;
    private boolean isAlive;
    private boolean isEnemy;

    public Character(String name, double hitPoints, double energy, double stamina, int level, int experience, int strength,
                     int defence, int quickness, int power, int protection, int focus, String affinity, boolean isAlive) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.energy = energy;
        this.stamina = stamina;
        this.level = level;
        this.experience = experience;
        this.strength = strength;
        this.defence = defence;
        this.quickness = quickness;
        this.power = power;
        this.protection = protection;
        this.focus = focus;
        this.affinity = affinity;
        this.isAlive = isAlive;
    }

    public Character(boolean isEnemy, String name, double hitPoints, double energy, double stamina, int expGivenWhenDead, int strength,
                     int defence, int quickness, int power, int protection, int focus, String affinity, boolean isAlive) {
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
        this.affinity = affinity;
        this.isEnemy = isEnemy;
    }

    public String getName() {
        return name;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public double getEnergy() {
        return energy;
    }

    public double getStamina() {
        return stamina;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
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

    /*
    Imię/nazwa
    Punkty życia;
    Punkty mana;
    Punkty stamina;
    Poziom;
    Aktualne punkty doświadczenia;
    Doświadczenie za zabicie;
    Plecak;
     */
}
