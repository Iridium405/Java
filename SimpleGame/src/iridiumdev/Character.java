package iridiumdev;

public abstract class Character {
    private String name;
    private double hitPoints;
    private double energy;
    private double stamina;
    private double money;
    private int level;
    private int experience;
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

    public Character(String name, double hitPoints, double energy, double stamina, int level, int experience, int skillPoint,
                     int strength, int defence, int quickness, int power, int protection, int focus, boolean isAlive) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.energy = energy;
        this.stamina = stamina;
        this.level = level;
        this.experience = experience;
        this.skillPoint = skillPoint;
        this.strength = strength;
        this.defence = defence;
        this.quickness = quickness;
        this.power = power;
        this.protection = protection;
        this.focus = focus;
        this.isAlive = isAlive;
    }

    public Character(boolean isEnemy, String name, double hitPoints, double energy, double stamina, int expGivenWhenDead, int strength,
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

    public Character(double money, String name, double hitPoints, double energy, double stamina, int expGivenWhenDead, int strength,
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

    public double getMoney() {
        return money;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public void levelChecking() {
        if(this.experience >= 200 && this.experience < 400) {
            this.level = 2;
        } else if(this.experience >= 400 && this.experience < 800) {
            this.level = 3;
        } else if(this.experience >= 800 && this.experience < 1400) {
            this.level = 4;
        } else if(this.experience >= 1400 && this.experience < 2800) {
            this.level = 5;
        }
    } //USE after every combat(). / method tested.

    public int higherStat(int characterStat_1, int characterStat_2){
        if(characterStat_1 >= characterStat_2){
            return characterStat_1;
        } else {
            return characterStat_2;
        }
    }
}
