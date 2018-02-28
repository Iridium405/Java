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
    public WarriorClass (String name, double life, double mana, double stamina, int level, int experience, ArrayList<CombatObjects> equipment, int strengh, int inteligence, int defence, boolean isAlive) {
        super (name, 120, 20, 100, 1, 0, equipment, 5, 2, 3, true);
    }

}
