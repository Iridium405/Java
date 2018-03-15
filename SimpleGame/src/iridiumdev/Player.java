package iridiumdev;

import java.util.ArrayList;

public class Player extends Character {

    public Player(String name, double hitPoints, double energy, double stamina, int strength, int defence, int quickness, int power, int protection, int focus) {
        super(name, hitPoints, energy, stamina, 1, 0, strength, defence, quickness, power, protection, focus, "good", true);
    }


}
