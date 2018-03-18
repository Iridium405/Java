package iridiumdev;

import java.util.ArrayList;

public class Player extends Character {
    private int level;
    private int experience;

    public Player(String name, double hitPoints, double energy, double stamina, int level, int experience, int strength, int defence, int quickness, int power, int protection, int focus) {
        super(name, hitPoints, energy, stamina, 2, strength, defence, quickness, power, protection, focus, true);
        this.level = level;
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void levelChecking() {
        if(this.experience >= 0 && this.experience < 200) {
            this.level = 1;
        } else if(this.experience >= 200 && this.experience < 400) {
            this.level = 2;
        } else if(this.experience >= 400 && this.experience < 800) {
            this.level = 3;
        } else if(this.experience >= 800 && this.experience < 1400) {
            this.level = 4;
        } else if(this.experience >= 1400 && this.experience < 2800) {
            this.level = 5;
        }
    } //USE after every combat(). / method tested.




}
