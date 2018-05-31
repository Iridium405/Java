package iridiumdev;

public class Player extends Character {
    private int level;
    private int experience;
    private int initiative;
    private Weapon weapon;
    private Armour torso;
    private Armour head;
    private Armour other;
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
        if(this.experience >= 0 && this.experience < 200) {
            this.level = 1;
        } else if(this.experience >= 200 && this.experience < 600) {
            this.level = 2;
        } else if(this.experience >= 600 && this.experience < 1200) {
            this.level = 3;
        } else if(this.experience >= 1200 && this.experience < 2000) {
            this.level = 4;
        } else if(this.experience >= 2000 && this.experience < 3000) {
            this.level = 5;
        } else if(this.experience >= 3000 && this.experience < 4500) {
            this.level = 6;
        } else if(this.experience >= 4500 && this.experience < 7500) {
            this.level = 7;
        }
    }

    public int makePhysicalDamage(){
        weapon.makeDamage();
        return weapon.getDamageMade(); //* physicalAttackRating;
    }
}

/*
    TODO: wprowadzić pole int tempLevel.
          (zapisywany będzie obecny poziom (przed przyznaniem doświadczenia), następnie będzie porównywany
          z poziomem po przyznaniu doświadczenia -> jeśli będzie różnica - "Congratulations! Level up!", oraz nowe punkty umiejętności)
 */