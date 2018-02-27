package iridiumdev;

import java.util.ArrayList;

public class WarriorClass extends Character implements IFightingSkills {
    /*
    Override Punkty życia
    Override Punkty stamina
    Siła
    Intelekt
    Obrona
     */
    public WarriorClass (String name, double life, double mana, double stamina, int level, int experience, int expGivenWhenDead, ArrayList<CombatObjects> equipment, int strengh, int inteligence, int defence) {
        super (name, life, mana, stamina, level, experience, expGivenWhenDead, equipment, strengh, inteligence, defence);
    }

}
