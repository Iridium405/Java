package iridiumdev;

public class Npc extends Character {

    public Npc(boolean isEnemy, String name, double hitPoints, double energy, double stamina, int expGivenWhenDead, int strength, int defence, int quickness, int power, int protection, int focus, String affinity, boolean isAlive) {
        super(isEnemy, name, hitPoints, energy, stamina, expGivenWhenDead, strength, defence, quickness, power, protection, focus, affinity, isAlive);
    }
}
