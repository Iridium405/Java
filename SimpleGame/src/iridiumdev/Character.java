package iridiumdev;

import java.util.ArrayList;

public class Character {
    private String name;
    private double life;
    private double mana;
    private double stamina;
    private int level;
    private int experience;
    private int expGivenWhenDead;
    private ArrayList<CombatObjects> equipment;
    private int strengh;
    private int inteligence;
    private int defence;

    public Character(String name, double life, double mana, double stamina, int level, int experience, int expGivenWhenDead, ArrayList<CombatObjects> equipment, int strengh, int inteligence, int defence) {
        this.name = name;
        this.life = life;
        this.mana = mana;
        this.stamina = stamina;
        this.level = level;
        this.experience = experience;
        this.expGivenWhenDead = expGivenWhenDead;
        this.equipment = new ArrayList<CombatObjects>();
        this.strengh = strengh;
        this.inteligence = inteligence;
        this.defence = defence;
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
