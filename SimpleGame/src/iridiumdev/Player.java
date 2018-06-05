package iridiumdev;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    private int temporaryLevel;
    private int level;
    private int experience;
    private int initiative;
    private Weapon weapon;
    private Armour torso;
    private Armour head;
    private Armour other;
    private Spell spell_01;
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

    public List<Skill> skills = new ArrayList<>();
    public List<Spell> spells = new ArrayList<>();

    public void addSkill(Skill skill){
        int maxSkillsKnown = 7;
        if(skills.size() <= maxSkillsKnown) {
            if (!skills.contains(skill)) {
                skills.add(skill);
            } else {
                System.out.println("You already know that skill.");
            }
        } else {
            System.out.println("You cannot learn more skills.");
        }
    }

    public void addSpell(Spell spell){
        int maxSpellsKnown = 7;
        if(spells.size() <= maxSpellsKnown) {
            if (!spells.contains(spell)) {
                spells.add(spell);
            } else {
                System.out.println("You already remembered that incantation.");
            }
        } else {
            System.out.println("You cannot remember more incantations.");
        }
    }

    public void equipSkillSlot_01(List skills, Skill skill) {
        if (skills.contains(skill)){
            this.skill_01 = skill;
            System.out.println("Skill " + skill.getName() + " equipped.");
        } else {
            System.out.println("Cannot equip skill, you heaven't learned.");
        }
    }

    public void equipSkillSlot_02(List skills, Skill skill) {
        if (skills.contains(skill)){
            this.skill_02 = skill;
            System.out.println("Skill " + skill.getName() + " equipped.");
        } else {
            System.out.println("Cannot equip skill, you heaven't learned.");
        }
    }

    public void equipSkillSlot_03(List skills, Skill skill) {
        if (skills.contains(skill)){
            this.skill_03 = skill;
            System.out.println("Skill " + skill.getName() + " equipped.");
        } else {
            System.out.println("Cannot equip skill, you heaven't learned.");
        }
    }

    public void equipSpellSlot_01(List spells, Spell spell){
        if (spells.contains(spell)){
            this.spell_01 = spell;
            System.out.println("Spell " + spell.getName() + " equipped.");
        } else {
            System.out.println("Cannot equip incantation you haven't remembered.");
        }
    }

    public void equipSpellSlot_02(List spells, Spell spell){
        if (spells.contains(spell)){
            this.spell_02 = spell;
            System.out.println("Spell " + spell.getName() + " equipped.");
        } else {
            System.out.println("Cannot equip incantation you haven't remembered.");
        }
    }

    public void equipSpellSlot_03(List spells, Spell spell){
        if (spells.contains(spell)){
            this.spell_03 = spell;
            System.out.println("Spell " + spell.getName() + " equipped.");
        } else {
            System.out.println("Cannot equip incantation you haven't remembered.");
        }
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
            newLevelChecking(temporaryLevel,level);
        } else if(this.experience >= lvl_02 && this.experience < lvl_03) {
            this.temporaryLevel = level;
            this.level = 2;
            newLevelChecking(temporaryLevel,level);
        } else if(this.experience >= lvl_03 && this.experience < lvl_04) {
            this.temporaryLevel = level;
            this.level = 3;
            newLevelChecking(temporaryLevel,level);
        } else if(this.experience >= lvl_04 && this.experience < lvl_05) {
            this.temporaryLevel = level;
            this.level = 4;
            newLevelChecking(temporaryLevel,level);
        } else if(this.experience >= lvl_05 && this.experience < lvl_06) {
            this.temporaryLevel = level;
            this.level = 5;
            newLevelChecking(temporaryLevel,level);
        } else if(this.experience >= lvl_06 && this.experience < lvl_07) {
            this.temporaryLevel = level;
            this.level = 6;
            newLevelChecking(temporaryLevel,level);
        } else if(this.experience >= lvl_07 && this.experience < lvl_08) {
            this.temporaryLevel = level;
            this.level = 7;
            newLevelChecking(temporaryLevel,level);
        }
    }

    private void newLevelChecking(int temporaryLevel, int level){
        if (temporaryLevel < level) {
            System.out.println("Level Up!");
            this.setAbilityPoints(getAbilityPoints() + 3);
        }
    }

    public int makePhysicalDamage(){
        weapon.makeDamage();
        return weapon.getDamageMade(); //* physicalAttackRating;
    }
}