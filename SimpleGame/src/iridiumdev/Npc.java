package iridiumdev;

public class Npc extends Character {

    public Npc(int money, String name, int hitPoints, int energy, int stamina, int expGivenWhenDead,
               int strength, int defence, int quickness, int power, int protection, int focus) {
        super(money, name, hitPoints, energy, stamina, expGivenWhenDead, strength, defence, quickness, power,
                protection, focus, true, false);
    }
}
