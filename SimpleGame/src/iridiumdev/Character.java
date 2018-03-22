package iridiumdev;


public abstract class Character {
    private String name;
    private double hitPoints;
    private double energy;
    private double stamina;
    private int money;
    private int skillPoint;
    private int expGivenWhenDead;
    private double strength;
    private double defence;
    private int quickness;
    private int power;
    private double protection;
    private int focus;
    private boolean isAlive;
    private boolean isEnemy;
    // private double money/coins;

    public Character(String name, double hitPoints, double energy, double stamina, int skillPoint,
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

    public Character(int money, String name, double hitPoints, double energy, double stamina, int expGivenWhenDead, int strength,
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

    Equipment equipment = new Equipment();

    public String getName() {
        return name;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
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

    public double getStrength() {
        return strength;
    }

    public double getDefence() {
        return defence;
    }

    public int getQuickness() {
        return quickness;
    }

    public int getPower() {
        return power;
    }

    public double getProtection() {
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

    public double physicalAttackRatio(Character defending){
        double physicalDamage = getStrength() + equipment.getWeapon(0).makeDamage();
        double physicalDefence = defending.getDefence() + defending.equipment.getArmour(0).getDefence();
        double attackRatio = physicalDamage / physicalDefence;

        if(attackRatio > 0) {
            return attackRatio;
        } else {
            return 0.1;
        }
    }

    public double energyAttackRatio(Character defending){
        return 0;
    }
}
