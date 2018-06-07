package iridiumdev;


public abstract class Character {
    private String name;
    private int hitPoints;
    private int maxHitPoints;
    private int energy;
    private int maxEnergy;
    private int stamina;
    private int maxStamina;
    private int money;
    private int abilityPoints;
    private int expGivenWhenDead;
    private int strength;
    private int defence;
    private int quickness;
    private int power;
    private int protection;
    private int focus;
    private boolean isAlive;
    private boolean isEnemy;
    // private int money/coins;

    public Character(String name, int hitPoints, int energy, int stamina, int abilityPoints,
                     int strength, int defence, int quickness, int power, int protection, int focus, boolean isAlive) {
        this.name = name;
        this.hitPoints = hitPoints; // zrobić currentHitPoints i try {if (currentHitPoints > hitPoints} catch (OutOfBoundExceptions) {);
        this.energy = energy;
        this.stamina = stamina;
        this.abilityPoints = abilityPoints;
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

    Equipment equipment = new Equipment();
    IncantationFactory incantations = new IncantationFactory();
    SkillFactory abilities = new SkillFactory();

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints() {
        this.maxHitPoints = getHitPoints();
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy() {
        this.maxEnergy = getEnergy();
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina() {
        this.maxStamina = getStamina();
    }

    public int getMoney() {
        return money;
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void setAbilityPoints(int abilityPoints) {
        this.abilityPoints = abilityPoints;
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public int statChecker(){
        if (this.quickness > this.focus){
            return this.quickness;
        } else if (this.focus > this.quickness){
            return this.focus;
        } else {
            if (this.strength > this.power){
                return this.quickness;
            } else if (this.power > this.strength) {
                return this.focus;
            } else {
                if (this.stamina > this.energy) {
                    return this.quickness;
                } else if (this.energy > this.stamina) {
                    return this.focus;
                } else {
                    return quickness;
                }
            }
        }
    }

    public boolean lifeCheck(){
        if (this.hitPoints <= 0) {
            setAlive(false);
            return true;
        } else {
            return false;
        }
    }

}
