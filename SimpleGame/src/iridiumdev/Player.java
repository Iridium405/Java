package iridiumdev;

public class Player extends Character {

    public Player(String name, double hitPoints, double energy, double stamina, int experience, int strength, int defence, int quickness, int power, int protection, int focus) {
        super(name, hitPoints, energy, stamina, 1, experience, strength, defence, quickness, power, protection, focus, true);
    }


}
