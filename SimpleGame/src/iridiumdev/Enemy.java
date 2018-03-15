package iridiumdev;

import java.util.ArrayList;

public class Enemy extends Character {

    public Enemy(String name, double hitPoints, double energy, double stamina, int expGivenWhenDead, int strength, int defence, int quickness, int power, int protection, int focus) {
        super(true, name, hitPoints, energy, stamina, expGivenWhenDead, strength, defence, quickness, power, protection, focus, "evil", true);
    }

    public static Enemy randomEnemyLvl_1(int random){
        switch(random){
            case 1:
                Enemy enemy_01 = new Enemy("Goblin Marauder", 60,0,60,20,3,2,4,1,2,1);
                return enemy_01;
            case 2:
                Enemy enemy_02 = new Enemy("Goblin Shaman", 50,70,20,30,1,2,1,3,2,4);
                return enemy_02;
            case 3:
                Enemy enemy_03 = new Enemy("Goblin Assassin", 20,50,50,40,5,2,5,5,2,5);
                return enemy_03;
            default:
                return null;
        }
    }


}
