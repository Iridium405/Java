package iridiumdev;

public class Player extends Character {

    public Player(String name, double hitPoints, double energy, double stamina, int level, int strength, int defence, int quickness, int power, int protection, int focus) {
        super(name, hitPoints, energy, stamina, level, 0, strength, defence, quickness, power, protection, focus, true);
    }


}
