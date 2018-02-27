package iridiumdev;

import java.util.ArrayList;

public class MageClass extends Character implements IMagicSkills {
    /*
    Override Punkty życia
    Override Punkty mana
    Siła
    Intelekt
    Obrona
     */
    public MageClass (String name, double life, double mana, double stamina, int level, int experience, int expGivenWhenDead, ArrayList<CombatObjects> equipment, int strengh, int inteligence, int defence) {
        super(name, life, mana, stamina, level, experience, expGivenWhenDead, equipment, strengh, inteligence, defence);
    }
}
