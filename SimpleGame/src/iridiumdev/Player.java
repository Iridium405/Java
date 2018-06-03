package iridiumdev;

public class Player extends Character {
    private int temporaryLevel;
    private int level;
    private int experience;
    private int initiative;
    private Weapon weapon;
    private Armour torso;
    private Armour head;
    private Armour other;
    private Spell spell_01 = new Magic_Healing("Uzdrowienie", "Life");
    private Spell spell_02;
    private Spell spell_03;
    private Skill skill_01;
    private Skill skill_02;
    private Skill skill_03;
    private int physicalAttackRating = 1; // = weapon quality + strength + skills;
    private int magicalAttackRating = 1; // = magical weapon bonus + power + skills;

    public Player(String name, int hitPoints, int energy, int stamina,
                  int strength, int defence, int quickness, int power, int protection, int focus) {
        super(name, hitPoints, energy, stamina, 2, strength, defence, quickness, power, protection, focus, true);
        this.level = 1;
        this.experience = 0;
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getTorso() {
        return torso;
    }

    public void setTorso(Armour torso) {
        this.torso = torso;
    }

    public Armour getHead() {
        return head;
    }

    public void setHead(Armour head) {
        this.head = head;
    }

    public Armour getOther() {
        return other;
    }

    public void setOther(Armour other) {
        this.other = other;
    }

    public void levelChecking() {
        int lvl_02 = 200;
        int lvl_03 = 600;
        int lvl_04 = 1200;
        int lvl_05 = 2000;
        int lvl_06 = 3000;
        int lvl_07 = 4500;
        int lvl_08 = 7500;

        if(this.experience >= 0 && this.experience < lvl_02) {
            this.temporaryLevel = level;
            this.level = 1;
            newLevelChecker(temporaryLevel,level);
        } else if(this.experience >= lvl_02 && this.experience < lvl_03) {
            this.temporaryLevel = level;
            this.level = 2;
            newLevelChecker(temporaryLevel,level);
        } else if(this.experience >= lvl_03 && this.experience < lvl_04) {
            this.temporaryLevel = level;
            this.level = 3;
            newLevelChecker(temporaryLevel,level);
        } else if(this.experience >= lvl_04 && this.experience < lvl_05) {
            this.temporaryLevel = level;
            this.level = 4;
            newLevelChecker(temporaryLevel,level);
        } else if(this.experience >= lvl_05 && this.experience < lvl_06) {
            this.temporaryLevel = level;
            this.level = 5;
            newLevelChecker(temporaryLevel,level);
        } else if(this.experience >= lvl_06 && this.experience < lvl_07) {
            this.temporaryLevel = level;
            this.level = 6;
            newLevelChecker(temporaryLevel,level);
        } else if(this.experience >= lvl_07 && this.experience < lvl_08) {
            this.temporaryLevel = level;
            this.level = 7;
            newLevelChecker(temporaryLevel,level);
        }
    }

    private void newLevelChecker(int temporaryLevel, int level){
        if (temporaryLevel < level) {
            System.out.println("Level Up!");
            this.setSkillPoint(getSkillPoint() + 2);
        }
    }

    public int makePhysicalDamage(){
        weapon.makeDamage();
        return weapon.getDamageMade(); //* physicalAttackRating;
    }
}