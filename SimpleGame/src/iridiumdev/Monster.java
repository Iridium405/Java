package iridiumdev;

import java.util.ArrayList;

public class Monster extends Character implements IMagicSkills {
    /*


     */
    public Monster (String name, double life, double mana, double stamina, int level, int experience, int expGivenWhenDead, ArrayList<CombatObjects> equipment, int strengh, int inteligence, int defence) {
        super(name, life, mana, stamina, level, experience, expGivenWhenDead = 20*level, equipment, strengh, inteligence, defence);
    }

}
