package iridiumdev;

public class Enemy extends Character {
    private int initiative;

    private Dice dice = new Dice();

    public Enemy(String name, int hitPoints, int energy, int stamina, int expGivenWhenDead, int strength, int defence, int quickness, int power, int protection, int focus) {
        super(true, name, hitPoints, energy, stamina, expGivenWhenDead, strength, defence, quickness, power, protection, focus, true);
        this.initiative = statChecker() + dice.throwDice(12);

    }

    public int getInitiative() {
        return initiative;
    }

}
