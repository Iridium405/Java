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
    public MageClass (String name, double life, double mana, double stamina, int level, int experience, ArrayList<CombatObjects> equipment, int strengh, int inteligence, int defence, boolean isAlive) {
        super (name, 100, 120, 20, 1, 0, equipment, 2, 5, 3, true);
    }
}
